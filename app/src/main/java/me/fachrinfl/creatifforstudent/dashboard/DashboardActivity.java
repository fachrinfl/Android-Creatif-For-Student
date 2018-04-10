package me.fachrinfl.creatifforstudent.dashboard;

import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.fachrinfl.creatifforstudent.R;
import me.fachrinfl.creatifforstudent.dashboard.topnews.TopNewsAdapter;
import me.fachrinfl.creatifforstudent.dashboard.topnews.TopNewsModel;
import me.relex.circleindicator.CircleIndicator;

public class DashboardActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView tvTitle,tvSubTitle, tvQouteToday, tvQoute, tvQouteBy, tvTopNews, tvAnnouncement;
    ViewPager viewPager;
    TopNewsAdapter adapter;
    CircleIndicator indicator;
    Handler handler;
    Runnable runnable;
    Timer timer;

    // <---------- Top News
    String [] strTitle = {
            "THE NEXTDEV COMPETITION 2017 MENYAMBANGI KOTA PADANG. KESEMPATAN EMAS UNTUK MAHASISWA UPI YPTK PADANG. FREE INSERT",
            "DOSEN TEKNIK INFORMATIKA UNIVERSITAS PUTRA INDONESIA YPTK PADANG LAUNCHING APLIKASI ANDROID",
            "PROGRAM STUDI TEKNIK INFORMATIKA UNIVERSITAS PUTRA INDONESIA YPTK PADANG TERAKREDITASI B",
            "PROGRAM STUDI TEKNIK INFORMATIKA UNIVERSITAS PUTRA INDONESIA YPTK PADANG LAUNCHING APLIKASI ANDROID",
            "PENGUNJUNG WEBSITE PROGRAM STUDI TEKNIK INFORMATIKA UNIVERSITAS PUTRA INDONESIA YPTK PADANG MENCAPAI 6000 TOTAL PENGUNJUNG"
    };

    int [] strImage = {
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e
    };
    // Top News ---------->

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Font
        String fontBold = "fonts/Ubuntu-Bold.ttf";
        String fontLight = "fonts/Ubuntu-Light.ttf";

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvTitle.setTypeface(Typeface.createFromAsset(getBaseContext().getAssets(), fontBold));

        tvSubTitle = (TextView) findViewById(R.id.tvSubTitle);
        tvSubTitle.setTypeface(Typeface.createFromAsset(getBaseContext().getAssets(), fontLight));
        
        tvTopNews = (TextView) findViewById(R.id.tvTopNews);
        tvTopNews.setTypeface(Typeface.createFromAsset(getBaseContext().getAssets(), fontLight));

        tvQouteToday = (TextView) findViewById(R.id.tvSubTitle);
        tvQouteToday.setTypeface(Typeface.createFromAsset(getBaseContext().getAssets(), fontLight));

        tvQoute = (TextView) findViewById(R.id.tvQoute);
        tvQoute.setTypeface(Typeface.createFromAsset(getBaseContext().getAssets(), fontBold));

        tvQouteBy = (TextView) findViewById(R.id.tvQouteBy);
        tvQouteBy.setTypeface(Typeface.createFromAsset(getBaseContext().getAssets(), fontLight));

        // <-------- View Pager

        viewPager = (ViewPager) findViewById(R.id.viewPager_id);
        indicator = (CircleIndicator) findViewById(R.id.circleIndicator_id);

        List<TopNewsModel> sampleNews = new ArrayList<>();
        for (int i=0; i<strTitle.length; i++){
            TopNewsModel news = new TopNewsModel();
            news.title = strTitle[i];
            news.image = strImage[i];
            sampleNews.add(news);
        }

        adapter = new TopNewsAdapter(getBaseContext(), sampleNews);
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                int i = viewPager.getCurrentItem();

                if (i == adapter.getCount() -1){
                    i = 0;
                    viewPager.setCurrentItem(i, true);
                } else {
                    i++;
                    viewPager.setCurrentItem(i, true);
                }
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        }, 4000, 4000);

        // View Pager ---------->

    }
}
