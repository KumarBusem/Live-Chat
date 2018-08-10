package com.roberto.manfreda.live.chat.views;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.roberto.manfreda.live.chat.R;

public class MainView extends Fragment {
    protected static final String TAG = MainView.class.getSimpleName();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_view, container, false);

        return view;
    }
}
