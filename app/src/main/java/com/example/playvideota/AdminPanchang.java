package com.example.playvideota;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class AdminPanchang extends AppCompatActivity {

    ImageView pachangDailyImageView;
    EditText panchangDailyTitleTextView, panchangDailyTitleDescriptionTextView, panchangDailyFestivalTextView;
    FirebaseStorage storage;
    FirebaseDatabase database;
    Button submitPanchangButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panchang);

        storage = FirebaseStorage.getInstance();
        database = FirebaseDatabase.getInstance();

        pachangDailyImageView = findViewById(R.id.pachangDailyImageView);
        panchangDailyFestivalTextView = findViewById(R.id.panchangDailyFestivalTextView);
        panchangDailyTitleDescriptionTextView = findViewById(R.id.panchangDailyTitleDescriptionTextView);
        panchangDailyTitleTextView = findViewById(R.id.panchangDailyTitleTextView);
        submitPanchangButton = findViewById(R.id.submitPanchangButton);

        pachangDailyImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 22);
            }
        });

//        submitPanchangButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String panchangTitle = panchangDailyTitleTextView.getText().toString();
//                String panchangDescription = panchangDailyTitleDescriptionTextView.getText().toString();
//                String panchangFestival = panchangDailyFestivalTextView.getText().toString();
//
//                submitPanchangButton.setVisibility(View.GONE);
//
//                if (panchangTitle.equalsIgnoreCase(null) || panchangDescription.equalsIgnoreCase("") || panchangFestival.equalsIgnoreCase("")) {
//                    Toast.makeText(AdminPanchang.this, "All Field is Mandatory", Toast.LENGTH_SHORT).show();
//                    submitPanchangButton.setVisibility(View.VISIBLE);
//                } else {
//                    database.getReference().child("Panchang")
//                            .child("daily_panchang")
//                            .child("panchang_title")
//                            .setValue(panchangTitle);
//
//                    database.getReference().child("Panchang")
//                            .child("daily_panchang")
//                            .child("panchang_description")
//                            .setValue(panchangDescription);
//
//                    database.getReference().child("Panchang")
//                            .child("daily_panchang")
//                            .child("panchang_festival")
//                            .setValue(panchangFestival).addOnSuccessListener(new OnSuccessListener<Void>() {
//                                @Override
//                                public void onSuccess(Void unused) {
//                                    Toast.makeText(AdminPanchang.this, "Added Successfully", Toast.LENGTH_SHORT).show();
//                                    submitPanchangButton.setVisibility(View.VISIBLE);
//                                }
//                            });
//
//                }
//
//            }
//        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data.getData() != null) {
            Uri uri = data.getData();
            pachangDailyImageView.setImageURI(uri);


//            final StorageReference reference = storage.getReference()
//                    .child("panchang")
//                    .child("daily_panchang")
//                    .child("daily_panchang_image");

//            channelIdList.add("UC04m8d9t8UeWZ5DuvQVnqiw");
//            channelIdList.add("UC6vQRTCxutg6fJLUGkDKynQ");
//            channelIdList.add("UC7ZivIYRB0fMSGh-THcTYbw");
//
//            channelIdList.add("UC8Igqo3g1U40n66BLb-xHuQ");
//            channelIdList.add("UCHq7ZxlzRRXimaBmk5QAxSQ");
//            channelIdList.add("UCOizxR3GwY7dmehMCAdvv9g");
//            channelIdList.add("UCRUAdVm9ZOF4JheOd8qIQHA");
//
//            channelIdList.add("UCSzOZ97LOpU-_AVlGfmD4rQ");
//            channelIdList.add("UCUUIz69kK3Ib5bD4hWLKAwA");
//            channelIdList.add("UCDe0DwkMVFfSIoiYdQUPQmQ");
//            channelIdList.add("UCfwa_zKl8-zC9rQDWIEixgg");
//            channelIdList.add("UCyIkg79GpPVF77qYKoAINtw");

//            UCHq7ZxlzRRXimaBmk5QAxSQ
//            UCDe0DwkMVFfSIoiYdQUPQmQ

//            final StorageReference reference = storage.getReference()
//                    .child("channel")
//                    .child("UCDe0DwkMVFfSIoiYdQUPQmQ")
//                    .child("UCDe0DwkMVFfSIoiYdQUPQmQbanner");

            final StorageReference reference = storage.getReference()
                    .child("channel")
                    .child("UCDe0DwkMVFfSIoiYdQUPQmQ")
                    .child("videos")
                    .child("UAeujvJqzgg");

            reference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
//                            database.getReference()
//                                    .child("Panchang")
//                                    .child("daily_panchang")
//                                    .child("daily_panchang_image")
//                                    .setValue(uri.toString());

//                            database.getReference().child("channels")
//                                    .child("UCHq7ZxlzRRXimaBmk5QAxSQ")
//                                    .child("channelProfile")
//                                    .setValue(uri.toString());
//
                            database.getReference().child("channels")
                                    .child("UCDe0DwkMVFfSIoiYdQUPQmQ")
                                    .child("videos")
                                    .child("UAeujvJqzgg")
                                    .setValue(uri.toString());

//                            database.getReference()
//                                    .child("Panchang")
//                                    .child("ThakurPanchang")
//                                    .child("feb")
//                                    .setValue(uri.toString());

                        }
                    });


                    Toast.makeText(AdminPanchang.this, "Daily panchang Image Updated", Toast.LENGTH_SHORT).show();
                }
            });


//            database.getReference().child("channels")
//                    .child("CT_QwW7Tbew5qrYNb2auqAQ")
//                    .child("channelName")
//                    .setValue("SanskarTV");

//
//            database.getReference().child("channels")
//                    .child("UC6vQRTCxutg6fJLUGkDKynQ")
//                    .child("channelName")
//                    .setValue("Saregama Bhakti");
//
//            database.getReference().child("channels")
//                    .child("UCOizxR3GwY7dmehMCAdvv9g")
//                    .child("channelName")
//                    .setValue("Gauri Gopal Tv");
//

//
//            database.getReference().child("channels")
//                    .child("UCDqkux3AH7P9hRjmunoUeAQ")
//                    .child("channelName")
//                    .setValue("BhaktiSagar Tv");
//


//
//            database.getReference().child("channels")
//                    .child("UCRUAdVm9ZOF4JheOd8qIQHA")
//                    .child("channelName")
//                    .setValue("Bhakthi TV");

//

        }
    }
}