package com.cherifcodes.myorchestra;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.navigation.Navigation;

import com.cherifcodes.myorchestra.model.Orchestra;
import com.cherifcodes.myorchestra.viewModels.OrchestraViewModel;
import com.cherifcodes.myorchestra.viewModels.SnapshotViewModel;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    private Orchestra mOrchestra;
    private OrchestraViewModel mOrchestraViewModel;
    private SnapshotViewModel mSnapshotViewModel;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSnapshotViewModel = ViewModelProviders.of(getActivity()).get(SnapshotViewModel.class);

        mOrchestraViewModel = ViewModelProviders.of(getActivity()).get(OrchestraViewModel.class);
        mOrchestraViewModel.getOrchestra().observe(getActivity(), new Observer<Orchestra>() {
            @Override
            public void onChanged(@Nullable Orchestra orchestra) {
                mOrchestra = orchestra;
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View homeFragment = inflater.inflate(R.layout.fragment_home, container, false);

        // Handle orchestra snapshot viewing
        Button orchestraSnapshotBtn = homeFragment.findViewById(R.id.btn_orchestra_snapshot);
        orchestraSnapshotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewOrchestraSnapshot();
            }
        });

        // Handle strings snapshot viewing
        Button stringsSnapshotBtn = homeFragment.findViewById(R.id.btn_strings_snapshot);
        stringsSnapshotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewStringsSnapshot();
            }
        });

        return homeFragment;
    }

    private void viewStringsSnapshot() {
        mSnapshotViewModel.setSnapshot(mOrchestra.getStringSnapshot());
        Navigation.findNavController(getActivity(), R.id.host_fragment).navigate(R.id.snapshotFragment);
    }

    private void viewOrchestraSnapshot() {
        mSnapshotViewModel.setSnapshot(mOrchestra.toString());
        Navigation.findNavController(getActivity(), R.id.host_fragment).navigate(R.id.snapshotFragment);
    }

}
