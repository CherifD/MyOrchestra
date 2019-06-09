package com.cherifcodes.myorchestra;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cherifcodes.myorchestra.model.Orchestra;
import com.cherifcodes.myorchestra.viewModels.OrchestraViewModel;

public class NewInstrumentActivity extends AppCompatActivity {
    private Orchestra mOrchestra;
    private OrchestraViewModel mOrchestraViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_instrument);

        mOrchestraViewModel = ViewModelProviders.of(this).get(OrchestraViewModel.class);

    }
}
