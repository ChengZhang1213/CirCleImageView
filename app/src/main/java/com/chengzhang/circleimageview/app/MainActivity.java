package com.chengzhang.circleimageview.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.chengzhang.circleimageview.app.ui.CircleImage;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CircleImage circleImage = (CircleImage) findViewById(R.id.iv_circleImages);
        circleImage.setImageResource(R.drawable.ic_test);
    }
}
