package com.cherifcodes.myorchestra;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.cherifcodes.myorchestra.viewModels.OrchestraViewModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewInstrumentFragment extends Fragment {

    private Spinner sectionSpinner;
    private EditText instrumentNameEt;
    private OrchestraViewModel mOrchestraViewModel;

    public NewInstrumentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mOrchestraViewModel = ViewModelProviders.of(getActivity()).get(OrchestraViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View newInstrument = inflater.inflate(R.layout.fragment_new_instrument, container, false);

        sectionSpinner = newInstrument.findViewById(R.id.spin_newInstrumentSection);
        instrumentNameEt = newInstrument.findViewById(R.id.et_newInstrumentName);
        // Create an ArrayAdapter using the string array and a default spinner layout
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.expense_categories_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        sectionSpinner.setAdapter(adapter);

        Button addNewInstrumentBtn = newInstrument.findViewById(R.id.btn_newInstrumentSave);
        addNewInstrumentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewInstrument();
            }
        });

        return newInstrument;
    }

    private void addNewInstrument() {
        String instrumentName = instrumentNameEt.getText().toString();
        String selectedSection = sectionSpinner.getSelectedItem().toString();
        if(TextUtils.isEmpty(instrumentName)){
            Toast.makeText(getContext(), "Please enter a name for the new instrument",
                    Toast.LENGTH_LONG).show();
            return;

            // Validate section and save instrument
        } else if (!mOrchestraViewModel.addInstrument(instrumentName, selectedSection)) {
            Toast.makeText(getContext(), "Please select an instrument section.",
                    Toast.LENGTH_LONG).show();
            return;
        }
        Toast.makeText(getContext(), instrumentName + " was successfully added to " +
                "the " + selectedSection + " section.", Toast.LENGTH_LONG).show();
        instrumentNameEt.setText("");
    }
}
