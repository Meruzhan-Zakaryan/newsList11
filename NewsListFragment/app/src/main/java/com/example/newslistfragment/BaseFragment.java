package com.example.newslistfragment;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment implements OnCommunicationChangeListener{

    private OnCommunicationChangeListener onCommunicationChangeListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (!(context instanceof OnCommunicationChangeListener))
            throw new NotBaseTypeException();

        onCommunicationChangeListener = (OnCommunicationChangeListener) context;
    }

    @Override
    public void addFragment(Fragment fragment, int resId) {
        onCommunicationChangeListener.addFragment(fragment, resId);
    }
}
