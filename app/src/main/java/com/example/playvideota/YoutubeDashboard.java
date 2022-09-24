package com.example.playvideota;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.playvideota.adapter.YoutubeDashBoardAdapterInterface;
import com.example.playvideota.adapter.YoutubeDashboardAdapter;
import com.example.playvideota.adapter.YoutuberAdapter;
import com.example.playvideota.api.MySingleton;
import com.example.playvideota.model.YoutubeDashboradModel;
import com.example.playvideota.model.YoutuberModel;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class YoutubeDashboard extends AppCompatActivity implements YoutubeDashBoardAdapterInterface {

    ArrayList<YoutubeDashboradModel> list = new ArrayList<>();
    RecyclerView youtubeVideoRV;
    String youtubeAccountUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_dashboard);


        gettingItem();
        settingAdapter();
        loadYoutubeVideo();


    }


    private void loadYoutubeVideo() {
        youtubeAccountUrl = "https://youtube.googleapis.com/youtube/v3/search?part=snippet&channelId=UCK8sQmJBp8GCxrOtXWBpyEA&maxResults=20&q=news&type=video&videoDefinition=any&key=AIzaSyAcI_4tCAc7i6psHKyqpIzzdDjxfCR3VS0";

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

                    YoutubeDashboardAdapter youtubeDashboardAdapter1 = new YoutubeDashboardAdapter(getApplicationContext(), list,YoutubeDashboard.this::itemClicked);
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

        YoutubeDashboardAdapter youtubeDashboardAdapter3 = new YoutubeDashboardAdapter(getApplicationContext(), list,this);
        youtubeVideoRV.setAdapter(youtubeDashboardAdapter3);

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


    @Override
    public void itemClicked(String userId, String videoID) {
        System.out.println("ITEM CLICKED");
        System.out.println("Video ID : "+ videoID);
        System.out.println("LOADING VIDEO...");
//        loadVideoToYoutubeVideoPlayer(userId,videoID);

        Intent intent = new Intent(YoutubeDashboard.this, VideoPlayer.class);
        intent.putExtra("userId", userId);
        intent.putExtra("videoId",videoID);
        startActivity(intent);


        Toast.makeText(this, "succcess", Toast.LENGTH_SHORT).show();
    }
}