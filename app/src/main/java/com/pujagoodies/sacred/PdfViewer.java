package com.pujagoodies.sacred;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PdfViewer extends AppCompatActivity {
    public PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer);
        String stringUrl = getIntent().getStringExtra("pdfUrl");
        Uri uri = Uri.parse(Uri.decode(stringUrl));
        pdfView = findViewById(R.id.pdfViewer);
        pdfView.fromUri(uri).load();
        new RetrievePdfFromUrl(pdfView,this).execute(stringUrl);
    }

}
class RetrievePdfFromUrl extends AsyncTask<String,Void, InputStream>{

    private Context context;
    private PDFView pdfView;

    public RetrievePdfFromUrl(PDFView pdfView, PdfViewer pdfViewer) {
        this.pdfView = pdfView;
        this.context = pdfViewer;

    }

    @Override
    protected InputStream doInBackground(String... strings) {
        InputStream inputStream = null;
        try {
            URL url = new URL(strings[0]);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            if (httpURLConnection.getResponseCode() == 200)
            {
                inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            }
        } catch (Exception e) {
            Log.d("error",e.getMessage());
        }
        return inputStream;
    }

    @Override
    protected void onPostExecute(InputStream inputStream) {
        pdfView.fromStream(inputStream)
                .defaultPage(0).enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(context)).spacing(10).load();
    }
}