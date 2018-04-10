package me.fachrinfl.creatifforstudent.dashboard.topnews;

import android.content.Context;
import android.graphics.Typeface;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import me.fachrinfl.creatifforstudent.R;

public class TopNewsAdapter extends PagerAdapter {

    private Context context;
    LayoutInflater inflater;
    private List<TopNewsModel> topNewsModels;

    public TopNewsAdapter(Context context, List<TopNewsModel> topNewsModels) {
        this.topNewsModels = topNewsModels;
        this.context = context;
    }

    @Override
    public int getCount() {
        return topNewsModels.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.top_news_layout, container, false);

        final TopNewsModel sampleNews = topNewsModels.get(position);
        ImageView img = (ImageView) view.findViewById(R.id.imageView_id);
        Glide.with(context).load(sampleNews.image).into(img);

        TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        tvTitle.setText(sampleNews.title);
        tvTitle.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Ubuntu-Bold.ttf"));

//        img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Snackbar.make(v, "Image " + (position + 1) + " clicked", Snackbar.LENGTH_LONG).show();
//            }
//        });

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
