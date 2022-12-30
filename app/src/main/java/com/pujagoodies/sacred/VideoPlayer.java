package com.pujagoodies.sacred;

import static java.lang.Thread.sleep;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.playvideota.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants.PlaybackQuality;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.YouTubePlayerTracker;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.YouTubePlayerUtils;
import com.squareup.picasso.Picasso;

public class VideoPlayer extends AppCompatActivity  {

    String userId = "";
    String videoId = "";
    String videoTitle = "";
    String videoDescription = "";
    String videoLiveBroadcastContent = "";
    String channelName = "";
    String channelIcon = "";
    ImageView highQuality ;
    CardView qualityCardView;
    ImageView playbackSpeedButton ;
    CardView playBackSpeedCardView;

    YouTubePlayerTracker playerTracker;
    ProgressBar progressBarSeek ;

    YouTubePlayerListener listener;

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

//        initYouTubePlayerView();
        getLifecycle().addObserver(playVid);

        View customPlayerUi = playVid.inflateCustomPlayerUi(R.layout.custom_player_ui);



//        YouTubePlayerListener listener = new AbstractYouTubePlayerListener() {
//            @Override
//            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
//                // using pre-made custom ui
//                DefaultPlayerUiController defaultPlayerUiController = new DefaultPlayerUiController(youTubePlayerView, youTubePlayer);
//                youTubePlayerView.setCustomPlayerUi(defaultPlayerUiController.getRootView());
//            }
//        };
//
//        // disable iframe ui
//        IFramePlayerOptions options = new IFramePlayerOptions.Builder().controls(0).build();
//        youTubePlayerView.initialize(listener, options);


        listener = new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer youTubePlayer) {




                CustomPlayerUiController customPlayerUiController = new CustomPlayerUiController(VideoPlayer.this, customPlayerUi, youTubePlayer, playVid);
                youTubePlayer.addListener(customPlayerUiController);



                playerTracker = new YouTubePlayerTracker();
                youTubePlayer.addListener(playerTracker);
                playVid.addFullScreenListener(customPlayerUiController);


//                FadeViewHelper fadeViewHelper = new FadeViewHelper(customPlayerUi);
//                fadeViewHelper.setAnimationDuration(FadeViewHelper.DEFAULT_ANIMATION_DURATION);
//                fadeViewHelper.setFadeOutDelay(FadeViewHelper.DEFAULT_FADE_OUT_DELAY);
//                fadeViewHelper.toggleVisibility();
//                youTubePlayer.addListener(fadeViewHelper);



                setVidePlaybackSpeed(youTubePlayer);
                setVideoQualityListener(youTubePlayer, playerTracker);
                YouTubePlayerUtils.loadOrCueVideo(youTubePlayer,getLifecycle(),videoId,0f);

                youTubePlayer.loadVideo(videoId,playerTracker.getVideoDuration());


//                DefaultPlayerUiController defaultPlayerUiController = new DefaultPlayerUiController(playVid, youTubePlayer);
//                defaultPlayerUiController.showYouTubeButton(false);
//                defaultPlayerUiController.showMenuButton(false);
//                defaultPlayerUiController.showUi(false);

//                playVid.setCustomPlayerUi(defaultPlayerUiController.getRootView());
//                playVid.setCustomPlayerUi(customPlayerUi);

            }
        };

//        // disable web ui
        IFramePlayerOptions options = new IFramePlayerOptions.Builder().controls(0).build();
        playVid.initialize(listener,true,options);
    }



    private void initYouTubePlayerView() {
//        playVid.inflateCustomPlayerUi(R.layout.custom_player_ui);
        View customPlayerUi = playVid.inflateCustomPlayerUi(R.layout.custom_player_ui);

        IFramePlayerOptions iFramePlayerOptions = new IFramePlayerOptions.Builder()
                .controls(0)
                .build();

        getLifecycle().addObserver(playVid);

        playVid.initialize(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {

                CustomPlayerUiController customPlayerUiController = new CustomPlayerUiController(VideoPlayer.this, customPlayerUi, youTubePlayer, playVid);
                youTubePlayer.addListener(customPlayerUiController);

                playerTracker = new YouTubePlayerTracker();
                youTubePlayer.addListener(playerTracker);
                playVid.addFullScreenListener(customPlayerUiController);

                YouTubePlayerUtils.loadOrCueVideo(
                        youTubePlayer, getLifecycle(),
                        videoId,0f
                );
            }
        }, true, iFramePlayerOptions);
    }





    private void setVidePlaybackSpeed(YouTubePlayer youTubePlayer) {

        playbackSpeedButton = findViewById(R.id.playbackSpeedButton);
        playBackSpeedCardView = findViewById(R.id.playBackSpeedCardView);


        Button oneX = findViewById(R.id.oneX);
        Button onePointFiveX = findViewById(R.id.onePointFive);
        Button twoX = findViewById(R.id.twoX);
        Button normal = findViewById(R.id.normal);

        Button zeroPointTwoFive = findViewById(R.id.zeroPointTwoFive);
        Button zeroPointFive = findViewById(R.id.zeroPointFive);

        playbackSpeedButton.setOnClickListener((view)->{
            playBackSpeedCardView.setVisibility(View.VISIBLE);
            qualityCardView.setVisibility(View.GONE);


        });

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
        highQuality = findViewById(R.id.highQuality);
        qualityCardView = findViewById(R.id.qualityCardView);

        Button oneFourFourP = findViewById(R.id.oneFourFourP);
        Button twoFourZeroP = findViewById(R.id.twoFourZeroP);
        Button threeTwoZeroP = findViewById(R.id.threeTwoZeroP);
        Button fourEightZeroP = findViewById(R.id.fourEightZeroP);
        Button sevenTwoZeroP = findViewById(R.id.sevenTwoZeroP);
        Button oneZeroTwoFourP = findViewById(R.id.oneZeroTwoFourP);



        highQuality.setOnClickListener((view) ->{
            qualityCardView.setVisibility(View.VISIBLE);
            playBackSpeedCardView.setVisibility(View.GONE);
        });

        oneFourFourP.setOnClickListener(view -> {
            listener.onPlaybackQualityChange(youTubePlayer,PlaybackQuality.SMALL);
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