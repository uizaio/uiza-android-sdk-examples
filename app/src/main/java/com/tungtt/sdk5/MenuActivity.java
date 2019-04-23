package com.tungtt.sdk5;

import android.arch.lifecycle.LiveData;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;


public class MenuActivity extends AppCompatActivity {
    private Activity activity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        activity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        findViewById(R.id.bt_portrait).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, LivePortraitActivity.class);
                startActivity(intent);
            }
        });
    }
}
