package com.cherifcodes.myorchestra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.cherifcodes.myorchestra.model.instruments.Instrument;
import com.cherifcodes.myorchestra.model.instruments.InstrumentFactory;
import com.cherifcodes.myorchestra.model.ModelConstants;

public class MainActivity extends AppCompatActivity {

    private TextView testing_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testing_tv = findViewById(R.id.tv_testing);
        testing_tv.setText("Welcome to my Orchestra!\n\n");

        Instrument tuba = InstrumentFactory.createInstrument("Tuba", ModelConstants.BRASSWINDS);
        tuba.setEnabled(true);
        testing_tv.append(tuba.toString() + "\n\n");
        tuba.setEnabled(false);
        testing_tv.append(tuba.toString());
    }
}
