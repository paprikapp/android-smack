package hu.paprikapp.smack.soup.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.VideoView;

import java.util.Map;

import hu.paprikapp.smack.soup.R;

/**
 * @author Balazs Varga
 */
public abstract class SmackVideoSplashActivity extends Activity {

    private VideoView mVideoView;
    private Button mSkipIntroButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        initialize();
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        initialize();
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        initialize();
    }

    private void initialize() {
        mVideoView = (VideoView) findViewById(R.id.video);
        mSkipIntroButton = (Button) findViewById(R.id.skip_video_button);

        setupVideoView();
        setupSkipIntroButton();
    }

    private void setupVideoView() {
        if (mVideoView != null) {
            mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    startNextActivityAndFinishThis();
                }
            });
        }
    }

    private void setupSkipIntroButton() {
        if (mSkipIntroButton != null) {
            mSkipIntroButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    stopPlayback();
                    startNextActivityAndFinishThis();
                }
            });
        }
    }

    protected final void setVideoPath(String path) {
        if (mVideoView != null) {
            mVideoView.setVideoPath(path);
        }
    }

    protected final void setVideoURI(Uri uri) {
        if (mVideoView != null) {
            mVideoView.setVideoURI(uri);
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    protected final void setVideoURI(Uri uri, Map<String, String> headers) {
        if (mVideoView != null) {
            mVideoView.setVideoURI(uri, headers);
        }
    }

    protected final void startVideo() {
        if (mVideoView != null) {
            mVideoView.start();
        }
    }

    private void stopPlayback() {
        if (mVideoView != null) {
            mVideoView.stopPlayback();
        }
    }

    private void startNextActivityAndFinishThis() {
        startNextActivity();
        finish();
    }

    public abstract void startNextActivity();
}
