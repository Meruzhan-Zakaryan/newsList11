package com.example.newslistfragment;

import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.newslistfragment.adapters.PagerAdapter;
import com.example.newslistfragment.fragments.EmptyFragment;
import com.example.newslistfragment.fragments.FullScreenFragment;
import com.example.newslistfragment.fragments.NewsFragment;
import com.example.newslistfragment.news.News;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends BaseActivity implements OnSetItemFavorite {

    private FrameLayout frameLayout;
    private TabLayout tableLayout;
    private ViewPager viewPager;
    private NewsFragment newsFragment;
    private EmptyFragment emptyFragment;
    private FullScreenFragment fullScreenFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tableLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.viewpager_id);
        frameLayout = new FrameLayout(this);
        frameLayout.setId(R.id.fl_full);

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        newsFragment = new NewsFragment();
        emptyFragment = new EmptyFragment();
        pagerAdapter.addFragment(newsFragment, "News");
        pagerAdapter.addFragment(emptyFragment, "Empty");
        viewPager.setAdapter(pagerAdapter);
        tableLayout.setupWithViewPager(viewPager);
        fullScreenFragment = new FullScreenFragment();
        newsFragment.setOnSetItemFavorite(this);
    }

    @Override
    public void favoritNews(News news) {
        emptyFragment.setFavoritNewsList(news);

    }
}
