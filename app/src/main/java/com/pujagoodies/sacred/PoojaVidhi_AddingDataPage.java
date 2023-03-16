package com.pujagoodies.sacred;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.pujagoodies.sacred.model.UploadImageModel;
import com.pujagoodies.sacred.model.VideoModel;

import java.util.Objects;

public class PoojaVidhi_AddingDataPage extends AppCompatActivity {
    public int REQUEST_CODE = 1;
    TextInputEditText title, description, shortDescription, videoUrl;
    ProgressDialog progressDialog;
    ImageView imageView;
    TextView textViewTitle;
    Button buttonSelectImage, buttonUpload;
    DatabaseReference databaseReference;
    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef = storage.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pooja_vidhi_adding_data_page);
        progressDialog = new ProgressDialog(this);

        textViewTitle = findViewById(R.id.textViewTitle);
        Intent intent = getIntent();
        String titleString = intent.getStringExtra("title");
        textViewTitle.setText(titleString);

        databaseReference = FirebaseDatabase.getInstance().getReference("Pooja Vidhi/");

        buttonSelectImage = findViewById(R.id.buttonSelectImage);
        buttonUpload = findViewById(R.id.buttonUpload);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        shortDescription = findViewById(R.id.shortDescription);
        videoUrl = findViewById(R.id.videoUrl);
        imageView = findViewById(R.id.imageView);

        if (textViewTitle.getText().toString().equals("Trending on shri mandir")) {
            description.setVisibility(View.VISIBLE);
            videoUrl.setVisibility(View.GONE);
        } else if (textViewTitle.getText().toString().equals("Special To You")) {
            videoUrl.setVisibility(View.VISIBLE);
            description.setVisibility(View.GONE);
        }

        buttonSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectImage();
            }
        });

        buttonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void selectImage() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            // Get the URI of the selected image
            Uri imageUri = data.getData();
            Glide.with(this).load(imageUri).into(imageView);

            Uri uri = data.getData();
            String displayName = null;
            // Using the ContentResolver to get the file name from the media store
            ContentResolver contentResolver = getContentResolver();
            Cursor cursor = contentResolver.query(uri, null, null, null, null);
            if (cursor != null && cursor.moveToFirst()) {
                int nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
                displayName = cursor.getString(nameIndex);
                cursor.close();
            }

            // if the displayName is  not null then name will be added to the editText
            if (displayName != null) {
                Log.d("result", "Selected file name: " + displayName);
                title.setText(displayName.substring(0, displayName.length() - 4));

            }
        }

        buttonUpload.setOnClickListener(view -> uploadDataToFirebase(data.getData()));
    }

    private void uploadDataToFirebase(Uri data) {
        String titleString = Objects.requireNonNull(title.getText()).toString();
        String descriptionString = Objects.requireNonNull(description.getText()).toString();
        String shortDescriptionString = Objects.requireNonNull(shortDescription.getText()).toString();
        String urlString = Objects.requireNonNull(videoUrl.getText()).toString();
        if (textViewTitle.getText().toString().equals("Trending on shri mandir")) {
            if (!titleString.isEmpty() && !descriptionString.isEmpty() && !shortDescriptionString.isEmpty()) {
                progressDialog.setTitle("Uploading");
                StorageReference imageRef = storageRef.child("Pooja Vidhi/Images/").child(titleString);
                imageRef.putFile(data).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                        double progress = (100 * snapshot.getBytesTransferred()) / snapshot.getTotalByteCount();
                        progressDialog.setMessage("Progress - " + progress);
                        progressDialog.show();

                    }
                }).addOnSuccessListener(taskSnapshot -> {


                    StorageReference storageRef = taskSnapshot.getStorage();
                    Task<Uri> downloadUrlTask = storageRef.getDownloadUrl();
                    downloadUrlTask.addOnSuccessListener(uri -> {
                        UploadImageModel uploadImageModel = new UploadImageModel(titleString, shortDescriptionString, descriptionString, uri.toString());
                        databaseReference.child("Trending On Shri Mandir/").child(titleString + "/").setValue(uploadImageModel).addOnSuccessListener(aVoid -> {
                            Toast.makeText(getApplicationContext(), "File is uploaded", Toast.LENGTH_SHORT).show();
                        }).addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Failed to save PDF to database", Toast.LENGTH_SHORT).show());
                    }).addOnFailureListener(e -> {
                        Toast.makeText(getApplicationContext(), "Failed to get download URL", Toast.LENGTH_SHORT).show();
                    });

                    Toast.makeText(PoojaVidhi_AddingDataPage.this, "success uploaded", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(PoojaVidhi_AddingDataPage.this, "failed to upload", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                });


            } else
                Toast.makeText(this, "Enter the Title and Description!", Toast.LENGTH_SHORT).show();
        } else if (textViewTitle.getText().toString().equals("Special To You")) {
            if (!titleString.isEmpty() && !shortDescriptionString.isEmpty() && !urlString.isEmpty()) {
                progressDialog.setTitle("Uploading");
                StorageReference imageRef = storageRef.child("Pooja Vidhi/Images/").child(titleString);
                imageRef.putFile(data).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                        double progress = (100 * snapshot.getBytesTransferred()) / snapshot.getTotalByteCount();
                        progressDialog.setMessage("Progress - " + progress);
                        progressDialog.show();

                    }
                }).addOnSuccessListener(taskSnapshot -> {


                    StorageReference storageRef = taskSnapshot.getStorage();
                    Task<Uri> downloadUrlTask = storageRef.getDownloadUrl();
                    downloadUrlTask.addOnSuccessListener(uri -> {
                        VideoModel videoModel = new VideoModel(titleString, shortDescriptionString, uri.toString(), urlString);
                        databaseReference.child("Special To You/").child(titleString).setValue(videoModel).addOnSuccessListener(aVoid -> {
                            Toast.makeText(getApplicationContext(), "File is uploaded", Toast.LENGTH_SHORT).show();
                        }).addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Failed to save to database", Toast.LENGTH_SHORT).show());
                    }).addOnFailureListener(e -> {
                        Toast.makeText(getApplicationContext(), "Failed to get download URL", Toast.LENGTH_SHORT).show();
                    });

                    Toast.makeText(PoojaVidhi_AddingDataPage.this, "success uploaded", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(PoojaVidhi_AddingDataPage.this, "failed to upload", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                });


            } else
                Toast.makeText(this, "Enter the Title and Description!", Toast.LENGTH_SHORT).show();
        } else if (textViewTitle.getText().toString().equals("Pdf Uploader")) {
            if (!titleString.isEmpty() && !shortDescriptionString.isEmpty()) {
                progressDialog.setTitle("Uploading");
                StorageReference imageRef = storageRef.child(titleString + ".pdf");
                imageRef.putFile(data).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                        double progress = (100 * snapshot.getBytesTransferred()) / snapshot.getTotalByteCount();
                        progressDialog.setMessage("Progress - " + progress);
                        progressDialog.show();

                    }
                }).addOnSuccessListener(taskSnapshot -> {


                    StorageReference storageRef = taskSnapshot.getStorage();
                    Task<Uri> downloadUrlTask = storageRef.getDownloadUrl();
                    downloadUrlTask.addOnSuccessListener(uri -> {
                        VideoModel videoModel = new VideoModel(titleString, shortDescriptionString, uri.toString(), urlString);
                        databaseReference.child(titleString).setValue(videoModel).addOnSuccessListener(aVoid -> {
                            Toast.makeText(getApplicationContext(), "File is uploaded", Toast.LENGTH_SHORT).show();
                        }).addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Failed to save to database", Toast.LENGTH_SHORT).show());
                    }).addOnFailureListener(e -> {
                        Toast.makeText(getApplicationContext(), "Failed to get download URL", Toast.LENGTH_SHORT).show();
                    });

                    Toast.makeText(PoojaVidhi_AddingDataPage.this, "success uploaded", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(PoojaVidhi_AddingDataPage.this, "failed to upload", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                });


            } else
                Toast.makeText(this, "Enter the Title and Description!", Toast.LENGTH_SHORT).show();
        } else Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();

    }

}
