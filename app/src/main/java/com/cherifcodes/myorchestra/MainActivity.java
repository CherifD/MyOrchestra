package com.cherifcodes.myorchestra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView testing_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testing_tv = findViewById(R.id.tv_testing);
        testing_tv.setText("Welcome to my Orchestra!");

    }
}
