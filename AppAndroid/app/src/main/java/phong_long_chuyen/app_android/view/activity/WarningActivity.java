package phong_long_chuyen.app_android.view.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import phong_long_chuyen.app_android.R;

public class WarningActivity extends AppCompatActivity implements View.OnClickListener {

    private MediaPlayer mMediaPlayer;

    private Button mBtnOk;
    private Button mBtnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warning);
        initView();
        addEvent();

        mMediaPlayer = MediaPlayer.create(this, R.raw.beep_warning);
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                mMediaPlayer.start();
//            }
//        }, 1000);
        mMediaPlayer.start();
    }

    private void initView() {
        mBtnOk = findViewById(R.id.btn_ok);
        mBtnCancel = findViewById(R.id.btn_cancel);
    }

    private void addEvent() {
        mBtnOk.setOnClickListener(this);
        mBtnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_ok: {
                startActivity(new Intent(this, LoginActivity.class));
                break;
            }
            case R.id.btn_cancel: {
                break;
            }
        }
        finish();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mMediaPlayer != null) {
            if (mMediaPlayer.isPlaying()) {
                mMediaPlayer.stop();
            }
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

}
