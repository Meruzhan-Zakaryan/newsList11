package com.example.newslistfragment.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newslistfragment.OnItemClicked;
import com.example.newslistfragment.R;
import com.example.newslistfragment.adapters.NewsAdapter;
import com.example.newslistfragment.news.News;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class EmptyFragment extends Fragment implements OnItemClicked {
    private View view;
    private RecyclerView recyclerView;
    private List<News> favoritNewsList = new ArrayList<>();
    private NewsAdapter newsAdapter;
    private String fullScreenUrl;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_empty, container, false);
        recyclerView = view.findViewById(R.id.rv_favorite);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        newsAdapter = new NewsAdapter(favoritNewsList);
        recyclerView.setAdapter(newsAdapter);
        newsAdapter.setOnItemClicked(this);

        return view;
    }

    public void setFavoritNewsList(News news) {
        favoritNewsList.add(news);
        newsAdapter.notifyDataSetChanged();
    }

    @Override
    public void itemClickInFragment(int position) {
        News news = favoritNewsList.get(position);
        fullScreenUrl=news.getUrl();

    }

    @Override
    public void checkBoxClick(int position) {
        favoritNewsList.remove(position);
        newsAdapter.notifyDataSetChanged();


    }
}
