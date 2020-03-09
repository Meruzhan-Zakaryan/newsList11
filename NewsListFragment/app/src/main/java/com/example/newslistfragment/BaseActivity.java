package com.example.newslistfragment;

import android.annotation.SuppressLint;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public abstract class BaseActivity extends AppCompatActivity implements OnCommunicationChangeListener {


    @SuppressLint("ResourceType")
    @Override
    public void addFragment(Fragment fragment, int id) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(id, fragment).addToBackStack(fragment.getClass().getSimpleName()).commit();
    }
}
