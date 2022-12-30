package com.pujagoodies.sacred;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.playvideota.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class FeedbackActivity extends AppCompatActivity {

    TextView maybeLater, ratingStatusTextview;
    EditText feedbackForm;
    RatingBar ratingBar;
    Button submitFeedbackButton;

    FirebaseDatabase database;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        database = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();


        intialiseComponent();

        submitFeedbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String feedbackFormdata = feedbackForm.getText().toString();

                database.getReference().child("feedback")
                        .child(auth.getUid().toString())
                        .child("data")
                        .setValue(feedbackFormdata).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(FeedbackActivity.this, "Thank You For Your Time", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        });

            }
        });

        maybeLater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                System.out.println("rating : " + rating);
                if (rating == 0) {
                    ratingBar.getOnRatingBarChangeListener();
                    ratingStatusTextview.setText("unrated");
                } else if (rating == 1) {
                    ratingStatusTextview.setText("Disliked It");
                } else if (rating == 2) {
                    ratingStatusTextview.setText("It Was Ok");
                } else if (rating == 3) {
                    ratingStatusTextview.setText("Liked It");
                } else if (rating == 4) {
                    ratingStatusTextview.setText("Loved It");
                } else if (rating == 5) {
                    ratingStatusTextview.setText("Excellent");
                }
            }
        });


    }

    private void intialiseComponent() {
        maybeLater = findViewById(R.id.maybeLater);
        feedbackForm = findViewById(R.id.feedbackForm);
        ratingBar = findViewById(R.id.ratingBar);
        submitFeedbackButton = findViewById(R.id.submitFeedbackButton);
        ratingStatusTextview = findViewById(R.id.ratingStatusTextview);
    }
}