package com.cherifcodes.myorchestra;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cherifcodes.myorchestra.model.Orchestra;
import com.cherifcodes.myorchestra.model.instruments.Instrument;
import com.cherifcodes.myorchestra.model.instruments.InstrumentFactory;
import com.cherifcodes.myorchestra.model.ModelConstants;
import com.cherifcodes.myorchestra.model.sections.Section;
import com.cherifcodes.myorchestra.model.sections.SectionFactory;
import com.cherifcodes.myorchestra.viewModels.OrchestraViewModel;
import com.cherifcodes.myorchestra.viewModels.SnapshotViewModel;

public class MainActivity extends AppCompatActivity {

    private SnapshotViewModel mSnapshotViewModel;
    private TextView testing_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        /*testing_tv.setText(mOrchestra.toString());
        mOrchestra.setStringsVolume(7);
        mOrchestra.startOrchestra();
        testing_tv.append(mOrchestra.toString());
        mOrchestra.enableStrings();
        testing_tv.append(mOrchestra.toString());
        mOrchestra.stopOrchestra();
        testing_tv.append(mOrchestra.toString());*/
    }


}
