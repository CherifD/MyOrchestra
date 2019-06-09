package com.cherifcodes.myorchestra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewSnapshotActivity extends AppCompatActivity {
    private TextView tv_snapshot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_snapshot);
        tv_snapshot = findViewById(R.id.tv_display_snapshot);
    }
}
