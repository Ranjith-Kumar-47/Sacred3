package com.example.playvideota;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.playvideota.adapter.YoutubeDashboardAdapter;
import com.example.playvideota.adapter.YoutuberAdapter;
import com.example.playvideota.api.MySingleton;
import com.example.playvideota.model.YoutubeDashboradModel;
import com.example.playvideota.model.YoutuberModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class YoutubeDashboard extends AppCompatActivity {

    YoutubeDashboardAdapter youtubeDashboardAdapter;
    ArrayList<YoutubeDashboradModel> list = new ArrayList<>();
    RecyclerView youtubeVideoRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_dashboard);


        gettingItem();
        settingAdapter();
        loadYoutubeVideo();


    }

    private void loadYoutubeVideo() {
        String youtubeAccountUrl = "https://youtube.googleapis.com/youtube/v3/search?part=snippet&channelId=UCK8sQmJBp8GCxrOtXWBpyEA&maxResults=20&q=news&type=video&videoDefinition=any&key=AIzaSyAcI_4tCAc7i6psHKyqpIzzdDjxfCR3VS0";

        System.out.println("LOADING VIDEO");
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, youtubeAccountUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("items");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        JSONObject idJsonObject = jsonObject.getJSONObject("id");
                        idJsonObject.getString("videoId");
                        System.out.println("VIDEO ID : "+idJsonObject.getString("videoId"));

                        JSONObject snippetJsonObject = jsonObject.getJSONObject("snippet");
                        snippetJsonObject.getString("title");
                        snippetJsonObject.getString("description");
                        snippetJsonObject.getString("liveBroadcastContent");

                        System.out.println("VIDEO TITLE : " +snippetJsonObject.getString("title") );
                        System.out.println("VIDEO DESCRIPTION : " +snippetJsonObject.getString("description") );

                        JSONObject thumbnailJsonObject = snippetJsonObject.getJSONObject("thumbnails");
                        JSONObject mediumJsonObject = thumbnailJsonObject.getJSONObject("high");

                        mediumJsonObject.getString("url");
                        System.out.println("URL : " + mediumJsonObject.getString("url"));

                        YoutubeDashboradModel youtubeDashboradModel = new YoutubeDashboradModel(
                                mediumJsonObject.getString("url"),
                                snippetJsonObject.getString("description"),
                                snippetJsonObject.getString("title"),
                                idJsonObject.getString("videoId"),
                                snippetJsonObject.getString("liveBroadcastContent")
                        );
                        list.add(youtubeDashboradModel);
                    }

                    YoutubeDashboardAdapter youtubeDashboardAdapter1 = new YoutubeDashboardAdapter(getApplicationContext(), list);
                    youtubeVideoRV.setAdapter(youtubeDashboardAdapter1);


                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO: Handle error

            }
        });

        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);

        System.out.println("LOADED VIDEO");
    }

    private void settingAdapter() {
        youtubeVideoRV = findViewById(R.id.youtubeVideoRV);
        youtubeVideoRV.setHasFixedSize(true);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        gridLayoutManager.setOrientation(youtubeVideoRV.VERTICAL);
        youtubeVideoRV.setLayoutManager(gridLayoutManager);

        youtubeDashboardAdapter = new YoutubeDashboardAdapter(getApplicationContext(), list);
        youtubeVideoRV.setAdapter(youtubeDashboardAdapter);

    }

    private void gettingItem() {
//
//        list.add(new YoutubeDashboradModel(R.drawable.ic_profile_svgrepo_com,"this is my video"));
//        list.add(new YoutubeDashboradModel(R.drawable.ic_profile_svgrepo_com,"this is my video"));
//        list.add(new YoutubeDashboradModel(R.drawable.ic_profile_svgrepo_com,"this is my video"));
//        list.add(new YoutubeDashboradModel(R.drawable.ic_profile_svgrepo_com,"this is my video"));
//        list.add(new YoutubeDashboradModel(R.drawable.ic_profile_svgrepo_com,"this is my video"));
//        list.add(new YoutubeDashboradModel(R.drawable.ic_profile_svgrepo_com,"this is my video"));
//        list.add(new YoutubeDashboradModel(R.drawable.ic_profile_svgrepo_com,"this is my video"));//       list.add(new YoutubeDashboradModel(R.drawable.ic_profile_svgrepo_com,"this is my video"));
    }
}