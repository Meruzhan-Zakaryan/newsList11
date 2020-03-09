package com.example.newslistfragment;

import androidx.annotation.LayoutRes;
import androidx.fragment.app.Fragment;

public interface OnCommunicationChangeListener {

    void addFragment(Fragment fragment, @LayoutRes int resId);
}
