package me.fachrinfl.creatifforstudent;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    TextView tvTitle, tvSubTitle;
    ProgressBar progressBar_linear;
    Handler handler;
    Runnable runnable;
    Timer timer;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Font
        String fontTitle = "fonts/Ubuntu-Bold.ttf";
        String fontSubTitle = "fonts/Ubuntu-Light.ttf";

        // Text Title
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvTitle.setTypeface(Typeface.createFromAsset(getBaseContext().getAssets(), fontTitle));

        // Text Sub Title
        tvSubTitle = (TextView) findViewById(R.id.tvSubTitle);
        tvSubTitle.setTypeface(Typeface.createFromAsset(getBaseContext().getAssets(), fontSubTitle));

        // ProgressBar Linear
        progressBar_linear = (ProgressBar) findViewById(R.id.progressBar_linear);
        progressBar_linear.setVisibility(View.VISIBLE);
        progressBar_linear.setProgress(0);
        progressBar_linear.setSecondaryProgress(0);
        progressBar_linear.setMax(100);

        // Set Timer
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {

                if (++i <= 100){
                    progressBar_linear.setProgress(i);
                    progressBar_linear.setSecondaryProgress(i+10);
                } else {
                    timer.cancel();
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        };
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        }, 100, 50);
    }
}
