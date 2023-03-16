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
import com.pujagoodies.sacred.model.PdfModel;

import java.util.Objects;

public class PoojaVidhi_AddingPdfPage extends AppCompatActivity {

    TextInputEditText pdfTitle, pdfShortDescription, imageTitle;
    TextView title;
    ProgressDialog progressDialog;
    Button buttonUploadPdf, buttonSelectPdf, buttonSelectPdfImage;
    DatabaseReference databaseReference;
    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef = storage.getReference();
    ImageView pdfImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pooja_vidhi_adding_pdf_page);
        progressDialog = new ProgressDialog(this);


        String getTitle = getIntent().getStringExtra("title");
        pdfShortDescription = findViewById(R.id.pdfShortDescription);
        title = findViewById(R.id.textViewPdfTitle);
        imageTitle = findViewById(R.id.imageTitle);
        pdfTitle = findViewById(R.id.pdfTitle);
        buttonSelectPdf = findViewById(R.id.buttonSelectPdf);
        buttonSelectPdfImage = findViewById(R.id.buttonSelectPdfImage);
        buttonUploadPdf = findViewById(R.id.buttonUploadPdf);
        pdfImageView = findViewById(R.id.imageViewPdf);

        title.setText(getTitle);

        databaseReference = FirebaseDatabase.getInstance().getReference("Pooja Vidhi/");
        buttonSelectPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectPdf();
            }
        });
        buttonSelectPdfImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectImage();
            }
        });
    }

    private void selectPdf() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.setType("application/pdf");
        startActivityForResult(Intent.createChooser(intent, "PDF FILE SELECTED"), 1);
    }

    private void selectImage() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 2);
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String displayName = null;
        if (resultCode == RESULT_OK) {
            if (requestCode == 1 && data != null) {
                Toast.makeText(this, "success pdf select", Toast.LENGTH_SHORT).show();
                // Do something with the image URI, such as display it in an ImageView

                Uri uri = data.getData();
                // Using the ContentResolver to get the file name from the media store
                ContentResolver contentResolver = getContentResolver();
                Cursor cursor = contentResolver.query(uri, null, null, null, null);
                if (cursor != null && cursor.moveToFirst()) {
                    int nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
                    displayName = cursor.getString(nameIndex);
                    cursor.close();
                }
                if (displayName != null) {
                    Log.d("result", "Selected file name: " + displayName);
                    pdfTitle.setText(uri.toString());

                }
            } else if (requestCode == 2 && data != null) {
                Toast.makeText(this, "success image select", Toast.LENGTH_SHORT).show();
                Uri imageUri = data.getData();
                String urlImage = imageUri.toString();
                Glide.with(this).load(imageUri).into(pdfImageView);

            }


//            if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
//                // Get the URI of the selected image
//                Uri imageUri = data.getData();
////            Glide.with(this).load(imageUri).into(pdfImageView);
//                // Do something with the image URI, such as display it in an ImageView
//
//                Uri uri = data.getData();
//                String displayName = null;
//                // Using the ContentResolver to get the file name from the media store
//                ContentResolver contentResolver = getContentResolver();
//                Cursor cursor = contentResolver.query(uri, null, null, null, null);
//                if (cursor != null && cursor.moveToFirst()) {
//                    int nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
//                    displayName = cursor.getString(nameIndex);
//                    cursor.close();
//                }

            // if the displayName is  not null then name will be added to the editText

        }

        buttonUploadPdf.setOnClickListener(view ->

                uploadDataToFirebase(data.getData()));
    }

    private void uploadDataToFirebase(Uri data) {
        String pdfTitleString = Objects.requireNonNull(pdfTitle.getText()).toString();
        String pdfDescriptionString = Objects.requireNonNull(pdfShortDescription.getText()).toString();
        String imageTitleString = Objects.requireNonNull(imageTitle.getText()).toString();
        if (title.getText().toString().equals("Pdf Uploader")) {
            if (!pdfTitleString.isEmpty() && !pdfDescriptionString.isEmpty() && !imageTitleString.isEmpty()) {
                progressDialog.setTitle("Uploading");
                StorageReference pdfRef = storageRef.child("Pooja Vidhi/Pdf/" + pdfTitleString);
                pdfRef.putFile(data).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                        long progress = (100 * snapshot.getBytesTransferred()) / snapshot.getTotalByteCount();
                        progressDialog.setMessage("Progress - " + progress);
                        progressDialog.show();
                    }
                }).addOnSuccessListener(taskSnapshot -> {

                    StorageReference storageRef = taskSnapshot.getStorage();
                    Task<Uri> downloadUrlTask = storageRef.getDownloadUrl();
                    downloadUrlTask.addOnSuccessListener(uri -> {
                        PdfModel pdfModel = new PdfModel(pdfTitleString, pdfDescriptionString, uri.toString(), "");
                        databaseReference.child("Pdf Uploader").child(pdfTitleString+"/").setValue(pdfModel).addOnSuccessListener(aVoid -> {
                            Toast.makeText(getApplicationContext(), "File is uploaded", Toast.LENGTH_SHORT).show();
                        }).addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Failed to save PDF to database", Toast.LENGTH_SHORT).show());
                    }).addOnFailureListener(e -> {
                        Toast.makeText(getApplicationContext(), "Failed to get download URL", Toast.LENGTH_SHORT).show();
                    });

                    Toast.makeText(PoojaVidhi_AddingPdfPage.this, "success uploaded", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(PoojaVidhi_AddingPdfPage.this, "failed to upload", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                });


            } else
                Toast.makeText(this, "Enter the Title and Description!", Toast.LENGTH_SHORT).show();
        }

    }


}