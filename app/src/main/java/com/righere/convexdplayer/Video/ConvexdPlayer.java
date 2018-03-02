package com.righere.convexdplayer.Video;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.righere.convexdplayer.R;

/**
 * Created by righere on 16-11-21.
 * ConvexdPlayer main player View
 */

public class ConvexdPlayer extends AppCompatActivity{

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("SDL22main");
        System.loadLibrary("SDL");
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convexdplayer);
    }
}
