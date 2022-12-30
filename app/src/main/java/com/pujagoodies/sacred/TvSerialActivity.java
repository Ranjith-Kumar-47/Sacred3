package com.pujagoodies.sacred;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.playvideota.R;
import com.pujagoodies.sacred.adapter.TvSerialAdapter;
import com.pujagoodies.sacred.api.MySingleton;
import com.pujagoodies.sacred.model.TvSerialModel;
import com.pujagoodies.sacred.model.YoutubeDashboradModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class TvSerialActivity extends AppCompatActivity {

    RecyclerView tvSerialRV;
    ArrayList<YoutubeDashboradModel> tvSerialList = new ArrayList<>();
    ArrayList<TvSerialModel> tvSerialModels = new ArrayList<>();
    String youtuberId = "";
    String youtubeAccountUrl = "";
    String playlistID = "";

    private String apiKey = "AIzaSyBnT_DTpgZKYoT6IYH5fNni7O9DUTN98dE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_serial);

        tvSerialRV = findViewById(R.id.tvSerialRV);
        tvSerialRV.setHasFixedSize(true);



//
//        tvSerialList.add(new YoutubeDashboradModel("" + R.drawable.ic_profile_svgrepo_com, "this is my video"));
//        tvSerialList.add(new YoutubeDashboradModel("" + R.drawable.ic_profile_svgrepo_com, "this is my video"));
//        tvSerialList.add(new YoutubeDashboradModel("" + R.drawable.ic_profile_svgrepo_com, "this is my video"));
//        tvSerialList.add(new YoutubeDashboradModel("" + R.drawable.ic_profile_svgrepo_com, "this is my video"));
//        tvSerialList.add(new YoutubeDashboradModel("" + R.drawable.ic_profile_svgrepo_com, "this is my video"));
//        tvSerialList.add(new YoutubeDashboradModel("" + R.drawable.ic_profile_svgrepo_com, "this is my video"));
//        tvSerialList.add(new YoutubeDashboradModel("" + R.drawable.ic_profile_svgrepo_com, "this is my video"));
//        tvSerialList.add(new YoutubeDashboradModel("" + R.drawable.ic_profile_svgrepo_com, "this is my video"));

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        gridLayoutManager.setOrientation(tvSerialRV.VERTICAL);
        tvSerialRV.setLayoutManager(gridLayoutManager);

        TvSerialAdapter tvSerialAdapter = new TvSerialAdapter(getApplicationContext(), tvSerialModels);
        tvSerialRV.setAdapter(tvSerialAdapter);

        loadYoutubeVideo();
    }

    private void loadYoutubeVideo() {
        youtuberId = getIntent().getStringExtra("youtuberId");
        playlistID = getIntent().getStringExtra("playlistId");

        System.out.println("Loading Other TV Serial ... ");

        String mahabharatUrl = "https://youtube.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId="+playlistID+"&key="+apiKey +"&part=contentDetails&maxResults=250";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, mahabharatUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONObject pageOptionJsonObject = response.getJSONObject("pageInfo");
                    pageOptionJsonObject.getString("totalResults");
//                    mahabharatTV.setText(pageOptionJsonObject.getString("totalResults").toString() + " " + "Episode");
                    System.out.println("Total Video : " + pageOptionJsonObject.getString("totalResults"));


                    JSONArray jsonArray = response.getJSONArray("items");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);


                        JSONObject snippetJsonObject = jsonObject.getJSONObject("snippet");
                        snippetJsonObject.getString("playlistId");
                        System.out.println("Playlist ID : " + snippetJsonObject.getString("playlistId"));


                        JSONObject idJsonObject = jsonObject.getJSONObject("contentDetails");
                        idJsonObject.getString("videoId");
                        System.out.println("VIDEO ID  : "+idJsonObject.getString("videoId"));

//                        JSONObject snippetJsonObject = jsonObject.getJSONObject("snippet");
                        snippetJsonObject.getString("title");
                        snippetJsonObject.getString("channelId");
                        snippetJsonObject.getString("description");
//                        snippetJsonObject.getString("liveBroadcastContent");



                        JSONObject thumbnailJsonObject = snippetJsonObject.getJSONObject("thumbnails");
                        JSONObject mediumJsonObject = thumbnailJsonObject.getJSONObject("high");

                        mediumJsonObject.getString("url");
                        System.out.println("Image URL  : " + mediumJsonObject.getString("url"));

                        TvSerialModel tvSerialModel = new TvSerialModel(
                                snippetJsonObject.getString("playlistId"),
                                idJsonObject.getString("videoId"),
                                snippetJsonObject.getString("title"),
                                snippetJsonObject.getString("description"),
                                snippetJsonObject.getString("channelId"),
                                mediumJsonObject.getString("url")

                        );

                        tvSerialModels.add(tvSerialModel);

//                        Picasso.with(getContext())
//                                .load(mediumJsonObject.getString("url").toString())
//                                .placeholder(R.drawable.ic_profile_svgrepo_com)
//                                .into(binding.mahabharatImageView);


                    }

                    TvSerialAdapter tvSerialAdapter = new TvSerialAdapter(getApplicationContext(), tvSerialModels);
                    tvSerialRV.setAdapter(tvSerialAdapter);


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

        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(jsonObjectRequest);

    }


}