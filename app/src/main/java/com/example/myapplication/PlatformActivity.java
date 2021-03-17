package com.example.myapplication;

import android.graphics.Point;
import android.view.Display;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class PlatformActivity extends AppCompatActivity {

    private PlatformView platformView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Display display = getWindowManager().getDefaultDisplay();
        Point resolution = new Point();
        display.getSize(resolution);

        platformView = new PlatformView(this, resolution.x, resolution.y);

        setContentView(platformView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        platformView.pause();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        platformView.resume();
    }
}