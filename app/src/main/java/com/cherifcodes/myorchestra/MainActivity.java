package com.cherifcodes.myorchestra;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.cherifcodes.myorchestra.model.Orchestra;
import com.cherifcodes.myorchestra.model.instruments.Instrument;
import com.cherifcodes.myorchestra.model.instruments.InstrumentFactory;
import com.cherifcodes.myorchestra.model.ModelConstants;
import com.cherifcodes.myorchestra.model.sections.Section;
import com.cherifcodes.myorchestra.model.sections.SectionFactory;
import com.cherifcodes.myorchestra.viewModels.OrchestraViewModel;

public class MainActivity extends AppCompatActivity {
    private Orchestra mOrchestra;
    private OrchestraViewModel mOrchestraViewModel;
    private TextView testing_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testing_tv = findViewById(R.id.tv_testing);

        mOrchestraViewModel = ViewModelProviders.of(this).get(OrchestraViewModel.class);
        mOrchestraViewModel.getOrchestra().observe(this, new Observer<Orchestra>() {
            @Override
            public void onChanged(@Nullable Orchestra orchestra) {
                mOrchestra = orchestra;
            }
        });
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
