package com.example.playvideota;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerFullScreenListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.YouTubePlayerTracker;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.DefaultPlayerUiController;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.PlayerUiController;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.utils.FadeViewHelper;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.views.YouTubePlayerSeekBar;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.views.YouTubePlayerSeekBarListener;

import java.sql.Time;
import java.util.Date;

class CustomPlayerUiController extends AbstractYouTubePlayerListener implements YouTubePlayerFullScreenListener {

    private final View playerUi;

    private Context context;
    private YouTubePlayer youTubePlayer;
    private YouTubePlayerView youTubePlayerView;

    // panel is used to intercept clicks on the WebView, I don't want the user to be able to click the WebView directly.
    View panel;
    View progressbar;
    TextView videoCurrentTimeTextView;
    TextView videoDurationTextView;
    ImageView highQuality;
    ImageView playBackSpeedButton;
    ImageView playPauseButton;
    ImageView enterExitFullscreenButton;

    CardView qualityCardView;
    CardView playBackCardView;
    Button oneFourFourP;
    Button twoFourZeroP;
    Button threeTwoZeroP;
    Button fourEightZeroP;
    Button sevenTwoZeroP;
    Button oneZeroTwoFourP;
    ProgressBar progressBarSeek;
    YouTubePlayerSeekBar youTubePlayerSeekBar;


    Handler handler;
    int progressCount = 0;

    final YouTubePlayerTracker playerTracker;
    boolean fullscreen = false;

    CustomPlayerUiController(Context context, View customPlayerUi, YouTubePlayer youTubePlayer, YouTubePlayerView youTubePlayerView) {
        this.playerUi = customPlayerUi;
        this.context = context;
        this.youTubePlayer = youTubePlayer;
        this.youTubePlayerView = youTubePlayerView;

        playerTracker = new YouTubePlayerTracker();
        youTubePlayer.addListener(playerTracker);

        initViews(customPlayerUi);
    }

    private void initViews(View playerUi) {
        panel = playerUi.findViewById(R.id.panel);
        progressbar = playerUi.findViewById(R.id.progressbar);

        playPauseButton = playerUi.findViewById(R.id.play_pause_button);
        enterExitFullscreenButton = playerUi.findViewById(R.id.enter_exit_fullscreen_button);

        playBackSpeedButton = playerUi.findViewById(R.id.playbackSpeedButton);
        playBackCardView = playerUi.findViewById(R.id.playBackSpeedCardView);

        highQuality = playerUi.findViewById(R.id.highQuality);
        qualityCardView = playerUi.findViewById(R.id.qualityCardView);

        oneFourFourP = playerUi.findViewById(R.id.oneFourFourP);
        twoFourZeroP = playerUi.findViewById(R.id.twoFourZeroP);
        threeTwoZeroP = playerUi.findViewById(R.id.threeTwoZeroP);
        fourEightZeroP = playerUi.findViewById(R.id.fourEightZeroP);
        sevenTwoZeroP = playerUi.findViewById(R.id.sevenTwoZeroP);
        oneZeroTwoFourP = playerUi.findViewById(R.id.oneZeroTwoFourP);


        youTubePlayerSeekBar = playerUi.findViewById(R.id.youtube_player_seekbar);

//        panel.setOnClickListener(view -> {
//            panel.setVisibility(View.VISIBLE);
//            new java.util.Timer().schedule(
//                    new java.util.TimerTask() {
//                        @Override
//                        public void run() {
//                            panel.setVisibility(View.GONE);
//                        }
//                    },
//                    5000
//            );
//        });



        youTubePlayer.addListener(youTubePlayerSeekBar);
        youTubePlayerSeekBar.setYoutubePlayerSeekBarListener(new YouTubePlayerSeekBarListener() {
            @Override
            public void seekTo(float time) {
                youTubePlayer.seekTo(time);
            }
        });
//
//        FadeViewHelper fadeViewHelper = new FadeViewHelper(playerUi);
//        fadeViewHelper.setAnimationDuration(FadeViewHelper.DEFAULT_ANIMATION_DURATION);
//        fadeViewHelper.setFadeOutDelay(FadeViewHelper.DEFAULT_FADE_OUT_DELAY);
//        youTubePlayer.addListener(fadeViewHelper);


        // ###############################

        highQuality.setOnClickListener((view) -> {
            playBackCardView.setVisibility(View.GONE);
            qualityCardView.setVisibility(View.VISIBLE);
        });



        playBackSpeedButton.setOnClickListener((view) -> {
            qualityCardView.setVisibility(View.GONE);
            playBackCardView.setVisibility(View.VISIBLE);
            System.out.println("Visibility speed : "+playBackCardView.getVisibility());
            System.out.println("Speed Clicked");
        });




        playPauseButton.setOnClickListener( (view) -> {
            if(playerTracker.getState() == PlayerConstants.PlayerState.PLAYING) youTubePlayer.pause();
            else youTubePlayer.play();
        });

        enterExitFullscreenButton.setOnClickListener( (view) -> {
            if(fullscreen) youTubePlayerView.exitFullScreen();
            else youTubePlayerView.enterFullScreen();

            fullscreen = !fullscreen;
        });
    }

    @Override
    public void onReady(@NonNull YouTubePlayer youTubePlayer) {
        progressbar.setVisibility(View.GONE);

    }

    @Override
    public void onStateChange(@NonNull YouTubePlayer youTubePlayer, @NonNull PlayerConstants.PlayerState state) {
//        if(state == PlayerConstants.PlayerState.PLAYING || state == PlayerConstants.PlayerState.PAUSED || state == PlayerConstants.PlayerState.VIDEO_CUED)
//        {
//            panel.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
//            progressbar.setVisibility(View.GONE);
//        }
//
//        else
//        if(state == PlayerConstants.PlayerState.BUFFERING)
//        {
//            panel.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
//            progressbar.setVisibility(View.VISIBLE);
//        }


        if(state == PlayerConstants.PlayerState.PLAYING ||  state == PlayerConstants.PlayerState.VIDEO_CUED)
        {
            panel.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
            playPauseButton.setImageResource(R.drawable.ic_baseline_play_circle_outline_24);
            progressbar.setVisibility(View.GONE);
            highQuality.setVisibility(View.GONE);
            playBackSpeedButton.setVisibility(View.GONE);
        }
        else if (state == PlayerConstants.PlayerState.PAUSED || state == PlayerConstants.PlayerState.VIDEO_CUED){
            panel.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
            playPauseButton.setImageResource(R.drawable.ic_baseline_motion_photos_paused_24);
            progressbar.setVisibility(View.GONE);
            highQuality.setVisibility(View.VISIBLE);
            playBackSpeedButton.setVisibility(View.VISIBLE);
        }
        else
        if(state == PlayerConstants.PlayerState.BUFFERING)
        {
            panel.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
            progressbar.setVisibility(View.VISIBLE);

        }



    }

    @Override
    public void onPlaybackQualityChange(@NonNull YouTubePlayer youTubePlayer, @NonNull PlayerConstants.PlaybackQuality playbackQuality) {

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onCurrentSecond(@NonNull YouTubePlayer youTubePlayer, float second) {
        int val = (int) second;
//        videoCurrentTimeTextView.setText(val+"");
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onVideoDuration(@NonNull YouTubePlayer youTubePlayer, float duration) {
        int vak = (int) duration;
//        videoDurationTextView.setText(vak+"");
    }

    @Override
    public void onYouTubePlayerEnterFullScreen() {
        ViewGroup.LayoutParams viewParams = playerUi.getLayoutParams();
        viewParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
        viewParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        playerUi.setLayoutParams(viewParams);
    }

    @Override
    public void onYouTubePlayerExitFullScreen() {
        ViewGroup.LayoutParams viewParams = playerUi.getLayoutParams();
        viewParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        viewParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        playerUi.setLayoutParams(viewParams);
    }
}