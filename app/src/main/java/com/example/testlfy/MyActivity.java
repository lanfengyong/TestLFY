package com.example.testlfy;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        overridePendingTransition(R.anim.scale,0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }
}
