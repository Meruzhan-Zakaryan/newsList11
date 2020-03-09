package com.example.newslistfragment;

import com.example.newslistfragment.news.News;

public interface OnItemClicked {
    void itemClickInFragment(int position);
    void checkBoxClick(int position);
}
