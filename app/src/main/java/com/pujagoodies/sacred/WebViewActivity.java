package com.pujagoodies.sacred;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

//import com.example.playvideota.R;
import com.pujagoodies.sacred.R;
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
        url = "https://www.youtube.com/watch?v="+id;


        WebViewClient webViewClient  = new WebViewClient();

        //Write the following code in OnCreate:
//        webview=(WebView)findViewById(R.id.webview);
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Loading...");


        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();

        webView.setWebViewClient(new WebViewClient()
        {
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
        System.out.println("website url : "+websiteUrl);
        if(websiteUrl!=null){
            webView.loadUrl(websiteUrl);
        }else {
            webView.loadUrl(url);
        }

//        String checkOrigin = i.getStringExtra("from_activity");
//        if(checkOrigin!=null && checkOrigin.equals("shoppinglist")){
//            btnAddtoShoppingList.setVisibility(View.GONE);
//            btnDeleteShoppingList.setVisibility(View.VISIBLE);
//        }



    }
}