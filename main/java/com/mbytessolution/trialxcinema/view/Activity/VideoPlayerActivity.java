package com.mbytessolution.trialxcinema.view.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.mbytessolution.trialxcinema.R;

public class VideoPlayerActivity extends AppCompatActivity {

    private PlayerView videoPlayerView;
    private SimpleExoPlayer simpleExoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_video_player);

        videoPlayerView = (PlayerView) findViewById(R.id.video_player_view);
        String videoUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4";


        initExoplayer(videoUrl);
    }

    private void initExoplayer(String videoUrl) {

        simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(this);
        videoPlayerView.setPlayer(simpleExoPlayer);
        DataSource.Factory dFactory = new DefaultDataSourceFactory(this,
                Util.getUserAgent(this, "Pahuch"));
        MediaSource mediaSource = new ExtractorMediaSource.Factory(dFactory)
                .createMediaSource(Uri.parse(videoUrl));

        simpleExoPlayer.prepare(mediaSource);
        simpleExoPlayer.setPlayWhenReady(true);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        simpleExoPlayer.release();
    }

}