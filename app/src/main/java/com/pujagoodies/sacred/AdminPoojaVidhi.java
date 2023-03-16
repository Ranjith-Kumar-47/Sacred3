package com.pujagoodies.sacred;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class AdminPoojaVidhi extends AppCompatActivity {

    Dialog dialog;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_pooja_vidhi);
        Button buttonTrendingOnShriMandir = findViewById(R.id.buttonTrendingOnShriMandir);
        Button buttonTodaySpecial = findViewById(R.id.buttonTodaySpecial);
        Button buttonSpecialToYou = findViewById(R.id.buttonSpecialToYou);
        Button buttonPdfViewer = findViewById(R.id.buttonPdfViewer);
        databaseReference = FirebaseDatabase.getInstance().getReference("Pooja Vidhi/");
        buttonTodaySpecial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new Dialog(AdminPoojaVidhi.this, android.R.style.Theme_NoTitleBar_Fullscreen);
                dialog.setContentView(R.layout.pooja_vidhi_add_new_tags);
                TextInputEditText textInputEditTextAddTags = dialog.findViewById(R.id.textInputEditTextAddTags);

                Button buttonUploadTags = dialog.findViewById(R.id.buttonUploadTags);
                buttonUploadTags.setOnClickListener(view1 -> {
                    String tags = Objects.requireNonNull(textInputEditTextAddTags.getText()).toString();
                    if (!tags.isEmpty()) {
                        databaseReference.child("Todays Special On Shree Mandir/").child(getTodaysDate()).setValue(tags).addOnSuccessListener(aVoid -> {
                            Toast.makeText(getApplicationContext(), "Tags uploaded", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }).addOnFailureListener(e -> {
                            dialog.dismiss();
                            Toast.makeText(getApplicationContext(), "Failed to upload database", Toast.LENGTH_SHORT).show();

                        });
                    } else
                        Toast.makeText(AdminPoojaVidhi.this, "Enter the tags", Toast.LENGTH_SHORT).show();
                });
                dialog.show();



            }
        });

        buttonTrendingOnShriMandir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminPoojaVidhi.this, PoojaVidhi_AddingDataPage.class);
                String title = buttonTrendingOnShriMandir.getText().toString();
                Toast.makeText(AdminPoojaVidhi.this, "" + title, Toast.LENGTH_SHORT).show();
                intent.putExtra("title", title);
                startActivity(intent);
            }
        });

        buttonSpecialToYou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminPoojaVidhi.this, PoojaVidhi_AddingDataPage.class);
                String title = buttonSpecialToYou.getText().toString();
                Toast.makeText(AdminPoojaVidhi.this, "" + title, Toast.LENGTH_SHORT).show();
                intent.putExtra("title", title);
                startActivity(intent);
            }
        });

        buttonPdfViewer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminPoojaVidhi.this, PoojaVidhi_AddingPdfPage.class);
                String title = buttonPdfViewer.getText().toString();
                Toast.makeText(AdminPoojaVidhi.this, "" + title, Toast.LENGTH_SHORT).show();
                intent.putExtra("title", title);
                startActivity(intent);
            }
        });

    }

    private String getTodaysDate() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String format = dateFormat.format(date);
        return format;
    }
}