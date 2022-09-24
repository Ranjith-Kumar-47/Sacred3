package com.example.playvideota;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class VideoPlayer extends YouTubeBaseActivity {

    String userId = "";
    String videoId = "";
    String videoTitle = "";
    String videoDescription = "";
    String videoLiveBroadcastContent = "";

    GoogleSignInClient mGoogleSignInClient;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        userId = getIntent().getStringExtra("userID");
        videoId = getIntent().getStringExtra("videoId");
        videoTitle = getIntent().getStringExtra("videoTitle");
        videoDescription = getIntent().getStringExtra("videoDescription");
        videoLiveBroadcastContent = getIntent().getStringExtra("videoLiveBroadcastContent");

        String url = "https://youtube.googleapis.com/youtube/v3/search?part=snippet&channelId=" +userId +"&maxResults=20&q=news&type=video&videoDefinition=any&key=AIzaSyBA5stcvWxiMf5PhX6HRQJJMhC2a6ovzxo";


        System.out.println("USERID VAl : "+userId);
        System.out.println("VIDEOID VAL :"+videoId);

        TextView videoTitleT, videoDescriptionT;

        videoTitleT = findViewById(R.id.contentTitle);
        videoDescriptionT = findViewById(R.id.contentDescription);

        videoTitleT.setText(videoTitle);
        videoDescriptionT.setText(videoDescription);




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
                finish();
            }
        });




    }
    private void logOutGoogleAccount() {
        ImageView logOutBtn  = findViewById(R.id.logoutBtn);
        logOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mGoogleSignInClient.signOut();
                Toast.makeText(VideoPlayer.this, "LOG OUT", Toast.LENGTH_SHORT).show();
                Intent intent  = new Intent(VideoPlayer.this, AuthActivity.class);
                startActivity(intent);
            }
        });
    }
}