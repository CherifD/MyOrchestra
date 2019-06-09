package com.cherifcodes.myorchestra;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cherifcodes.myorchestra.model.Orchestra;
import com.cherifcodes.myorchestra.viewModels.OrchestraViewModel;
import com.cherifcodes.myorchestra.viewModels.SnapshotViewModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class SnapshotFragment extends Fragment {

    private SnapshotViewModel mSnapshotViewModel;
    public SnapshotFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSnapshotViewModel = ViewModelProviders.of(getActivity()).get(SnapshotViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View snapshotView = inflater.inflate(R.layout.fragment_snapshot, container, false);
        final TextView tv_snapshot = snapshotView.findViewById(R.id.tv_snapshot_frgmt);

        mSnapshotViewModel.getSnapshot().observe(getActivity(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                tv_snapshot.setText(s);
            }
        });
        return snapshotView;
    }

}
