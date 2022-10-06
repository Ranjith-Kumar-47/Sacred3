package com.example.playvideota;

import static java.lang.Thread.sleep;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants.PlaybackQuality;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstantsKt;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerFullScreenListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.YouTubePlayerTracker;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.YouTubePlayerUtils;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.DefaultPlayerUiController;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.PlayerUiController;
import com.squareup.picasso.Picasso;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VideoPlayer extends AppCompatActivity  {

    String userId = "";
    String videoId = "";
    String videoTitle = "";
    String videoDescription = "";
    String videoLiveBroadcastContent = "";
    String channelName = "";
    String channelIcon = "";

    YouTubePlayerListener listener;
    YouTubePlayerTracker playerTracker;
    ProgressBar progressBarSeek ;

    GoogleSignInClient mGoogleSignInClient;
    com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView playVid;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                finish();
            }
        });

        initingAndGettingValue();
        loadingChannelNameAndImage();


        ImageView shareButton = (ImageView) findViewById(R.id.shareButton);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "this is sharing app");
                intent.putExtra(Intent.EXTRA_TEXT,"your application link here");
                startActivity(Intent.createChooser(intent,"Share Via"));
            }
        });

        playVid = findViewById(R.id.playVid);
        getLifecycle().addObserver(playVid);

        View customPlayerUi = playVid.inflateCustomPlayerUi(R.layout.custom_player_ui);


        listener = new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer youTubePlayer) {
                CustomPlayerUiController customPlayerUiController = new CustomPlayerUiController(VideoPlayer.this, customPlayerUi, youTubePlayer, playVid);
                youTubePlayer.addListener(customPlayerUiController);

                playerTracker = new YouTubePlayerTracker();
                youTubePlayer.addListener(playerTracker);
                playVid.addFullScreenListener(customPlayerUiController);

                setVidePlaybackSpeed(youTubePlayer);
                setVideoQualityListener(youTubePlayer, playerTracker);
                YouTubePlayerUtils.loadOrCueVideo(youTubePlayer,getLifecycle(),videoId,0f);

            }


            @Override
            public void onPlaybackRateChange(@NonNull com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer youTubePlayer, @NonNull PlayerConstants.PlaybackRate playbackRate) {
                TextView playbackSpeedTextView = findViewById(R.id.playback_speed_text_view);

                String playbackSpeed = "Playback speed: ";
//                playbackSpeedTextView.setText(playbackSpeed + playbackRate);
            }

            @Override
            public void onPlaybackQualityChange(@NonNull com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer youTubePlayer, @NonNull PlaybackQuality playbackQuality) {

                TextView playbackSpeedTextView = findViewById(R.id.playback_speed_text_view);
                String playbackSpeed = "Playback Quality: ";
                playbackSpeedTextView.setText(playbackSpeed + playbackQuality);

            }

        };


        // disable web ui
        IFramePlayerOptions options = new IFramePlayerOptions.Builder().controls(0).build();
        playVid.initialize(listener, options );
    }



    private void setVidePlaybackSpeed(YouTubePlayer youTubePlayer) {

        ImageView playbackSpeedButton = findViewById(R.id.playbackSpeedButton);
        CardView playBackSpeedCardView = findViewById(R.id.playBackSpeedCardView);


        Button oneX = findViewById(R.id.oneX);
        Button onePointFiveX = findViewById(R.id.onePointFive);
        Button twoX = findViewById(R.id.twoX);
        Button normal = findViewById(R.id.normal);

        Button zeroPointTwoFive = findViewById(R.id.zeroPointTwoFive);
        Button zeroPointFive = findViewById(R.id.zeroPointFive);

        playbackSpeedButton.setOnClickListener(view -> playBackSpeedCardView.setVisibility(View.VISIBLE));

        oneX.setOnClickListener(view -> {
            youTubePlayer.setPlaybackRate(PlayerConstants.PlaybackRate.RATE_1);
            playBackSpeedCardView.setVisibility(View.GONE);
        }
        );
        onePointFiveX.setOnClickListener(view -> {youTubePlayer.setPlaybackRate(PlayerConstants.PlaybackRate.RATE_1_5);
            playBackSpeedCardView.setVisibility(View.GONE);
        });
        twoX.setOnClickListener(view -> {youTubePlayer.setPlaybackRate(PlayerConstants.PlaybackRate.RATE_2);
            playBackSpeedCardView.setVisibility(View.GONE);
        });
        normal.setOnClickListener(view -> {youTubePlayer.setPlaybackRate(PlayerConstants.PlaybackRate.UNKNOWN);
            playBackSpeedCardView.setVisibility(View.GONE);
        });

        zeroPointFive.setOnClickListener(view -> {youTubePlayer.setPlaybackRate(PlayerConstants.PlaybackRate.RATE_0_5);
            playBackSpeedCardView.setVisibility(View.GONE);
        });

        zeroPointTwoFive.setOnClickListener(view -> {youTubePlayer.setPlaybackRate(PlayerConstants.PlaybackRate.RATE_0_25);
            playBackSpeedCardView.setVisibility(View.GONE);
        });


    }

    private void setVideoQualityListener(YouTubePlayer youTubePlayer, YouTubePlayerTracker playerTracker) {
        ImageView highQuality = findViewById(R.id.highQuality);
        CardView qualityCardView = findViewById(R.id.qualityCardView);

        Button oneFourFourP = findViewById(R.id.oneFourFourP);
        Button twoFourZeroP = findViewById(R.id.twoFourZeroP);
        Button threeTwoZeroP = findViewById(R.id.threeTwoZeroP);
        Button fourEightZeroP = findViewById(R.id.fourEightZeroP);
        Button sevenTwoZeroP = findViewById(R.id.sevenTwoZeroP);
        Button oneZeroTwoFourP = findViewById(R.id.oneZeroTwoFourP);



        highQuality.setOnClickListener(view -> qualityCardView.setVisibility(View.VISIBLE));

        oneFourFourP.setOnClickListener(view -> {
            listener.onPlaybackQualityChange(youTubePlayer,PlaybackQuality.UNKNOWN);
            youTubePlayer.loadVideo(videoId,playerTracker.getCurrentSecond());
            qualityCardView.setVisibility(View.GONE);
            System.out.println("THROUGH LISTENER");
        });

        twoFourZeroP.setOnClickListener(view -> {
            listener.onPlaybackQualityChange(youTubePlayer,PlaybackQuality.SMALL);
            youTubePlayer.loadVideo(videoId,playerTracker.getCurrentSecond());
            qualityCardView.setVisibility(View.GONE);
            System.out.println("THROUGH LISTENER");
        });

        threeTwoZeroP.setOnClickListener(view -> {
            listener.onPlaybackQualityChange(youTubePlayer,PlaybackQuality.HIGH_RES);
            youTubePlayer.loadVideo(videoId,playerTracker.getCurrentSecond());
            qualityCardView.setVisibility(View.GONE);
            System.out.println("THROUGH LISTENER");
        });

        fourEightZeroP.setOnClickListener(view -> {
            listener.onPlaybackQualityChange(youTubePlayer,PlaybackQuality.SMALL);
            youTubePlayer.loadVideo(videoId,playerTracker.getCurrentSecond());
            qualityCardView.setVisibility(View.GONE);
            System.out.println("THROUGH LISTENER");
        });

        sevenTwoZeroP.setOnClickListener(view -> {
            listener.onPlaybackQualityChange(youTubePlayer,PlaybackQuality.HD720);
            youTubePlayer.loadVideo(videoId,playerTracker.getCurrentSecond());
            qualityCardView.setVisibility(View.GONE);
            System.out.println("THROUGH LISTENER");
        });

        oneZeroTwoFourP.setOnClickListener(view -> {
            listener.onPlaybackQualityChange(youTubePlayer,PlaybackQuality.HD1080);
            youTubePlayer.loadVideo(videoId,playerTracker.getCurrentSecond());
            qualityCardView .setVisibility(View.GONE);
            System.out.println("THROUGH LISTENER");
        });



    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            playVid.enterFullScreen();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            playVid.exitFullScreen();
        }
    }


    private void initingAndGettingValue() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        userId = getIntent().getStringExtra("userID");
        videoId = getIntent().getStringExtra("videoId");
        videoTitle = getIntent().getStringExtra("videoTitle");
        videoDescription = getIntent().getStringExtra("videoDescription");
        videoLiveBroadcastContent = getIntent().getStringExtra("videoLiveBroadcastContent");
        channelName = getIntent().getStringExtra("channelName");
        channelIcon = getIntent().getStringExtra("channelIcon");

        // URL USED TO OPEN LINK
        String url = "https://youtube.googleapis.com/youtube/v3/search?part=snippet&channelId=" +userId +"&maxResults=20&q=news&type=video&videoDefinition=any&key=AIzaSyBA5stcvWxiMf5PhX6HRQJJMhC2a6ovzxo";

        TextView videoTitleT, videoDescriptionT;
        videoTitleT = findViewById(R.id.contentTitle);
        videoDescriptionT = findViewById(R.id.contentDescription);
        videoTitleT.setText(videoTitle);
        videoDescriptionT.setText(videoDescription);
    }

    private void loadingChannelNameAndImage() {
        ImageView profileUserImage;
        TextView youtuberName;

        profileUserImage = findViewById(R.id.profileUserImage);
        youtuberName = findViewById(R.id.youtuberName);

        channelIcon = getIntent().getStringExtra("channelIcon");
        channelName = getIntent().getStringExtra("channelName");

        Picasso.with(getApplicationContext())
                .load(channelIcon)
                .placeholder(R.drawable.ic_profile_svgrepo_com)
                .into(profileUserImage);

        youtuberName.setText(channelName);
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