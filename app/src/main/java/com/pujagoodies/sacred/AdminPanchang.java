package com.pujagoodies.sacred;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.playvideota.R;
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
    EditText adminVideoIdEditText,adminVideoTitleEditText,adminVideoDescriptionEditText;
    ImageButton submitVideoIdButton;
    ImageView adminLivevideoThumbnailImageView,adminLiveVideoYes,adminLiveVideoNo;

    String videoId = "";
    String videoTitle = "";
    String videoDescription = "";

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

        adminVideoTitleEditText  = findViewById(R.id.adminVideoTitleEditText);
        adminVideoDescriptionEditText = findViewById(R.id.adminVideoDescriptionEditText);



        pachangDailyImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 22);
            }
        });

        adminVideoIdEditText = findViewById(R.id.adminVideoIdEditText);
        submitVideoIdButton = findViewById(R.id.submitVideoIdButton);



        submitVideoIdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(adminVideoIdEditText.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(getApplicationContext(), "Enter Video Id", Toast.LENGTH_SHORT).show();
                }else if(adminVideoTitleEditText.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(getApplicationContext(), "Enter Video Title", Toast.LENGTH_SHORT).show();
                }else if(adminVideoDescriptionEditText.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(getApplicationContext(), "Enter Video Description", Toast.LENGTH_SHORT).show();
                }else {
                    database.getReference().child("LiveVideo")
                            .child("videos")
                            .child(adminVideoIdEditText.getText().toString())
                            .child(adminVideoIdEditText.getText().toString())
                            .setValue(adminVideoIdEditText.getText().toString()).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    videoId = adminVideoIdEditText.getText().toString();
                                    Toast.makeText(getApplicationContext(), "Video ID Added", Toast.LENGTH_SHORT).show();
                                }
                            });

                    database.getReference().child("LiveVideo")
                            .child("videos")
                            .child(adminVideoIdEditText.getText().toString())
                            .child("title")
                            .setValue(adminVideoTitleEditText.getText().toString()).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    videoTitle = adminVideoTitleEditText.getText().toString();
                                    Toast.makeText(getApplicationContext(), "Video Title Added", Toast.LENGTH_SHORT).show();
                                }
                            });

                    database.getReference().child("LiveVideo")
                            .child("videos")
                            .child(adminVideoIdEditText.getText().toString())
                            .child("description")
                            .setValue(adminVideoDescriptionEditText.getText().toString()).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    videoDescription = adminVideoDescriptionEditText.getText().toString();
                                    Toast.makeText(getApplicationContext(), "Video title Added", Toast.LENGTH_SHORT).show();
                                }
                            });
                }
            }
        });

        adminLivevideoThumbnailImageView = findViewById(R.id.adminLivevideoThumbnailImageView);
        adminLivevideoThumbnailImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                if(videoId.equalsIgnoreCase("")){
                    Toast.makeText(getApplicationContext(), "Enter Video Id First", Toast.LENGTH_SHORT).show();
                }else if(videoTitle.equalsIgnoreCase("")){
                    Toast.makeText(getApplicationContext(), "Enter Video Title First", Toast.LENGTH_SHORT).show();
                }else if(videoDescription.equalsIgnoreCase("")){
                    Toast.makeText(getApplicationContext(), "Enter Video Description First", Toast.LENGTH_SHORT).show();
                }
                else {
                    startActivityForResult(intent, 33);
                }
            }
        });

        adminLiveVideoYes = findViewById(R.id.adminLiveVideoYes);
        adminLiveVideoNo = findViewById(R.id.adminLiveVideoNo);

        adminLiveVideoYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adminLiveVideoYes.setVisibility(View.GONE);
                adminLiveVideoNo.setVisibility(View.GONE);
                database.getReference().child("LiveVideo")
                        .child("visibility")
                        .setValue("visible").addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(getApplicationContext(), "Video Visible", Toast.LENGTH_SHORT).show();
                                adminLiveVideoNo.setVisibility(View.VISIBLE);
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            }
                        });
            }
        });

        adminLiveVideoNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adminLiveVideoYes.setVisibility(View.GONE);
                adminLiveVideoNo.setVisibility(View.GONE);
                database.getReference().child("LiveVideo")
                        .child("visibility")
                        .setValue("gone").addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(getApplicationContext(), "Visibility Gone", Toast.LENGTH_SHORT).show();
                                adminLiveVideoYes.setVisibility(View.VISIBLE);
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            }
                        });
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

        if(requestCode == 22){
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

//            final StorageReference reference = storage.getReference()
//                    .child("channel")
//                    .child("UCDe0DwkMVFfSIoiYdQUPQmQ")
//                    .child("videos")
//                    .child("UAeujvJqzgg");

                final StorageReference reference = storage.getReference()
                        .child("thakurpanchang")
                        .child("dec");

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
//                            database.getReference().child("channels")
//                                    .child("UCDe0DwkMVFfSIoiYdQUPQmQ")
//                                    .child("videos")
//                                    .child("UAeujvJqzgg")
//                                    .setValue(uri.toString());

//                            database.getReference()
//                                    .child("Panchang")
//                                    .child("ThakurPanchang")
//                                    .child("dec")
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
        }else if(requestCode == 33){
            if (data.getData() != null) {
                Uri uri = data.getData();
                adminLivevideoThumbnailImageView.setImageURI(uri);

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

//            final StorageReference reference = storage.getReference()
//                    .child("channel")
//                    .child("UCDe0DwkMVFfSIoiYdQUPQmQ")
//                    .child("videos")
//                    .child("UAeujvJqzgg");

                final StorageReference reference = storage.getReference()
                        .child("LiveVideo")
                        .child("videos")
                        .child(videoId)
                        .child(videoId);

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
//                            database.getReference().child("channels")
//                                    .child("UCDe0DwkMVFfSIoiYdQUPQmQ")
//                                    .child("videos")
//                                    .child("UAeujvJqzgg")
//                                    .setValue(uri.toString());

                            database.getReference()
                                    .child("LiveVideo")
                                    .child("videos")
                                    .child(videoId)
                                    .child(videoId)
                                    .setValue(uri.toString());

                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);

                            }
                        });


                        Toast.makeText(AdminPanchang.this, "live Image Updated", Toast.LENGTH_SHORT).show();
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
}