package com.cherifcodes.myorchestra;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewInstrumentFragment extends Fragment {


    public NewInstrumentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View newInstrument = inflater.inflate(R.layout.fragment_new_instrument, container, false);

        return newInstrument;
    }

}
