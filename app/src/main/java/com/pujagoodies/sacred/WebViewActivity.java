package com.pujagoodies.sacred;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.webkit.URLUtil;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

//import com.example.playvideota.R;
import com.pujagoodies.sacred.R;

import java.net.URI;
import java.net.URISyntaxException;

public class WebViewActivity extends AppCompatActivity {

    WebView webView;
    ProgressDialog progressDialog;
    String id = "";
    String url = "";
    String websiteUrl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView = findViewById(R.id.webView);

        id = getIntent().getStringExtra("id");
        url = "https://www.youtube.com/watch?v=" + id;


        WebViewClient webViewClient = new WebViewClient();

        //Write the following code in OnCreate:
//        webview=(WebView)findViewById(R.id.webview);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();


        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
            }
        });

//        webView.setWebViewClient(webViewClient);

        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.setScrollbarFadingEnabled(false);

        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setAllowFileAccessFromFileURLs(true);
        webView.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);


        websiteUrl = getIntent().getStringExtra("websiteUrl");
        System.out.println("website url : " + websiteUrl);

        String default_url = "https://pujagoodies.com/";
        String default_url_youtube_video = "https://www.youtube.com/";

        if (getIntent().getExtras() != null) {
            String url_from_notif = getIntent().getExtras().getString("websiteUrl");
            String youtube_video_id = getIntent().getExtras().getString("id");
            String url_from_notif_youtube = "https://www.youtube.com/watch?v=" + youtube_video_id;
            if (url_from_notif != null) {
                if (URLUtil.isValidUrl(url_from_notif) && Patterns.WEB_URL.matcher(url_from_notif).matches()) {
                    default_url = url_from_notif;
                    Log.v("url_from_notif = ", default_url);
                }
            }
            if (youtube_video_id != null) {
                if (URLUtil.isValidUrl(url_from_notif_youtube) && Patterns.WEB_URL.matcher(url_from_notif_youtube).matches()) {
                    default_url = url_from_notif_youtube;
                    Log.v("url_from_notif_youtube ", default_url);
                }
            }
            if (getIntent().getData() != null) {
                String url_from_mail = getIntent().getData().toString();
                url_from_mail = url_from_mail.replace("pujagoodies://", "");
                if (URLUtil.isValidUrl(url_from_mail) && Patterns.WEB_URL.matcher(url_from_mail).matches()) {
                    default_url = url_from_mail;
                    Log.v("url_from_mail = ", default_url);
                }
            }
        }

        URI uri;
        try {
            uri = new URI(default_url);
            String domain = uri.getHost();
//            System.out.println("#####################################");
//            System.out.println("domain : "+domain);
//            System.out.println("default_url ta  : "+default_url);
//            System.out.println(" default_url.startsWith(\"https://pujagoodies.com/  : "+default_url.startsWith("https://pujagoodies.com/"));
//            System.out.println(" default_url.startsWith(\"https://pujagoodies.com/ Not  : "+!default_url.startsWith("https://pujagoodies.com/"));
//
//            System.out.println("URLUtil.isValidUrl(default_url): "+URLUtil.isValidUrl(default_url));
//            System.out.println("!URLUtil.isValidUrl(default_url): "+!URLUtil.isValidUrl(default_url));
//
//            System.out.println("Patterns.WEB_URL.matcher(default_url).matches() : "+Patterns.WEB_URL.matcher(default_url).matches());
//            System.out.println("!Patterns.WEB_URL.matcher(default_url).matches() : "+!Patterns.WEB_URL.matcher(default_url).matches());
//
//
//            System.out.println("#####################################");

            if (websiteUrl != null) {
                if (!default_url.startsWith("https://pujagoodies.com/") || !domain.equals("pujagoodies.com") || !URLUtil.isValidUrl(default_url) || !Patterns.WEB_URL.matcher(default_url).matches()) {
                    webView.loadUrl("about:blank");
                } else {
                    webView.loadUrl(default_url);
                }
            } else if (id != null) {
                if (!domain.equals("www.youtube.com") || !URLUtil.isValidUrl(default_url_youtube_video) || !Patterns.WEB_URL.matcher(default_url_youtube_video).matches()) {
                    webView.loadUrl("about:blank");
                } else {
                    webView.loadUrl(default_url);
                }
            }


        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}