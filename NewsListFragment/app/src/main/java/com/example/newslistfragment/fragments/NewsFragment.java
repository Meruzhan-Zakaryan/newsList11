package com.example.newslistfragment.fragments;


import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newslistfragment.BaseFragment;
import com.example.newslistfragment.OnSetItemFavorite;
import com.example.newslistfragment.news.News;
import com.example.newslistfragment.adapters.NewsAdapter;
import com.example.newslistfragment.news.NewsCreator;
import com.example.newslistfragment.OnItemClicked;
import com.example.newslistfragment.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends BaseFragment implements OnItemClicked {
    private View view;
    private RecyclerView recyclerView;
    private List<News> newsList = new ArrayList<>();
    private String urlFullScrenn;
    private NewsAdapter newsAdapter;
    private OnSetItemFavorite onSetItemFavorite;


    public void setOnSetItemFavorite(OnSetItemFavorite onSetItemFavorite) {
        this.onSetItemFavorite = onSetItemFavorite;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        NewsCreator.creatNews(newsList);
        view = inflater.inflate(R.layout.fragment_news, container, false);
        recyclerView = view.findViewById(R.id.rv_news);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        newsAdapter = new NewsAdapter(newsList);
        recyclerView.setAdapter(newsAdapter);
        newsAdapter.setOnItemClicked(this);
        return view;

    }


    @SuppressLint("ResourceType")
    @Override
    public void itemClickInFragment(int position) {
        addFragment(FullScreenFragment.newInstance(newsList.get(position).getUrl()), R.id.fl_full);
    }

    @Override
    public void checkBoxClick(int position) {
        News news = newsList.get(position);
        onSetItemFavorite.favoritNews(news);

    }
}
