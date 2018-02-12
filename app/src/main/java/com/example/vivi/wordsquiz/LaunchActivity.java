package com.example.vivi.wordsquiz;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


public class LaunchActivity extends AppCompatActivity {
    private static final String TAG = "TEST";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(LaunchActivity.this,MainActivity.class);
                startActivity(i);
                finish();
                Log.i(TAG, "run: ");
            }
        },3000); }



}

