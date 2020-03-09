package com.example.newslistfragment.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.newslistfragment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FullScreenFragment extends Fragment {

    private ImageView ivFullScreen;
    private String full;

    public static FullScreenFragment newInstance(String full){
        FullScreenFragment fragment = new FullScreenFragment();
        fragment.full = full;
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        View view = inflater.inflate(R.layout.fragment_full_screen, container, false);
        ivFullScreen = view.findViewById(R.id.iv_full_screen);
        Glide.with(this)
                .load(full)
                .into(ivFullScreen);
        return view;
    }

    public void setFull(String full) {
        this.full = full;
    }
}
