package com.roberto.manfreda.live.chat.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.roberto.manfreda.live.chat.R;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }
}
