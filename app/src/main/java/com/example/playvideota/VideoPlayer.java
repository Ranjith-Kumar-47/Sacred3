package com.example.playvideota;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class VideoPlayer extends YouTubeBaseActivity {

    String userID = "";
    String videoId = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        String url = "https://youtube.googleapis.com/youtube/v3/search?part=snippet&channelId=UCK8sQmJBp8GCxrOtXWBpyEA&maxResults=20&q=news&type=video&videoDefinition=any&key=AIzaSyAcI_4tCAc7i6psHKyqpIzzdDjxfCR3VS0";

        userID = getIntent().getStringExtra("userID");
        videoId = getIntent().getStringExtra("videoId");

        System.out.println("USERID VAl : "+userID);
        System.out.println("VIDEOID VAL :"+videoId);


        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.videoPlayer);
        youTubePlayerView.initialize(url, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(videoId);
                youTubePlayer.play();

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(VideoPlayer.this, "PLayed", Toast.LENGTH_SHORT).show();
            }
        });


        Button backButton = (Button) findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VideoPlayer.this, YoutubeDashboard.class);
                startActivity(intent);
            }
        });




    }
}