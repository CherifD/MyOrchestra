package com.cherifcodes.myorchestra;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

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

    private EditText stringVolumeEt;
    private EditText woodwindVolumeEt;
    private EditText brasswindVolumeEt;
    private EditText percussionVolumeEt;
    private EditText orchestraVolumeEt;

    private TextView orchestraPlayingTv;
    private String orchestraPlayingStatus;


    private Switch stringsSwitchBtn;
    private Switch woodwindsSwitchBtn;
    private Switch brasswindsSwitchBtn;
    private Switch percussionsSwitchBtn;

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

        mOrchestraViewModel.getPlayingStatus().observe(getActivity(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                orchestraPlayingStatus = s;
                if (orchestraPlayingTv != null)
                    orchestraPlayingTv.setText(orchestraPlayingStatus);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View homeFragment = inflater.inflate(R.layout.fragment_home, container, false);

        // Instantiate checkBoxes
        stringsSwitchBtn = homeFragment.findViewById(R.id.chb_strings_enabled);
        brasswindsSwitchBtn = homeFragment.findViewById(R.id.chb_brasswinds_enabled);
        woodwindsSwitchBtn = homeFragment.findViewById(R.id.chb_woodwinds_enabled);
        percussionsSwitchBtn = homeFragment.findViewById(R.id.chb_percussions_enabled);

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

        // Handle woodwinds snapshot viewing
        Button woodwindsSnapshotBtn = homeFragment.findViewById(R.id.btn_woodwinds_snapshot);
        woodwindsSnapshotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewWoodwindsSnapshot();
            }
        });

        // Handle brasswinds snapshot viewing
        Button brasswindsSnapshotBtn = homeFragment.findViewById(R.id.btn_brawinds_snapshot);
        brasswindsSnapshotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewBrasswindsSnapshot();
            }
        });

        // Handle percussions snapshot viewing
        Button percussionSnapshotBtn = homeFragment.findViewById(R.id.btn_percussions_snapshot);
        percussionSnapshotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPercussionSnapshot();
            }
        });

        ///////////////////// Handle volume increases ///////////////
        // Handle strings up volume
        ImageButton stringUpVolumeBtn = homeFragment.findViewById(R.id.btn_upStringsVolume);
        stringVolumeEt = homeFragment.findViewById(R.id.et_stringsVolume);
        stringUpVolumeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseStringVolume();
            }
        });

        // Handle woodwinds up volume
        ImageButton woodwindUpVolumeBtn = homeFragment.findViewById(R.id.btn_upWoodwindsVolume);
        woodwindVolumeEt = homeFragment.findViewById(R.id.et_woodwindsVolume);
        woodwindUpVolumeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseWoodwindVolume();
            }
        });

        // Handle brasswinds up volume
        ImageButton brasswindsUpVolumeBtn = homeFragment.findViewById(R.id.btn_upBrasswindsVolume);
        brasswindVolumeEt = homeFragment.findViewById(R.id.et_brasswindsVolume);
        brasswindsUpVolumeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseBrasswindVolume();
            }
        });

        // Handle percussion up volume
        ImageButton percussionUpVolumeBtn = homeFragment.findViewById(R.id.btn_upPercussionsVolume);
        percussionVolumeEt = homeFragment.findViewById(R.id.et_percussionsVolume);
        percussionUpVolumeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increasePercussionVolume();
            }
        });

        // Handle entire orchestra up volume
        ImageButton orchestraUpVolumeBtn = homeFragment.findViewById(R.id.btn_upOrchestraVolume);
        orchestraVolumeEt = homeFragment.findViewById(R.id.et_orchestraVolume);
        orchestraUpVolumeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseOrchestraVolume();
            }
        });
        //////////////// Handle volume decreases ///////////////////////////////////////

        // Handle entire orchestra volume decrease
        ImageButton orchestraDownVolumeBtn = homeFragment.findViewById(R.id.btn_downOrchestraVolume);
        orchestraDownVolumeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decreaseOrchestraVolume();
            }
        });

        // Handle strings volume decrease
        ImageButton stringsDownVolumeBtn = homeFragment.findViewById(R.id.btn_downStringsVolume);
        stringsDownVolumeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decreaseStringVolume();
            }
        });

        // Handle woodwinds volume decrease
        ImageButton woodWindsDownVolumeBtn = homeFragment.findViewById(R.id.btn_downWoodwindsVolume);
        woodWindsDownVolumeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decreaseWoodwindVolume();
            }
        });

        // Handle brasswinds volume decrease
        ImageButton brassWindsDownVolumeBtn = homeFragment.findViewById(R.id.btn_downBrasswindsVolume);
        brassWindsDownVolumeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decreaseBrasswindVolume();
            }
        });

        // Handle percussions volume decrease
        ImageButton percussionDownVolumeBtn = homeFragment.findViewById(R.id.btn_downPercussionsVolume);
        percussionDownVolumeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decreasePercussionVolume();
            }
        });

        // Handle orchestra stopping
        Button stopOrchestraBtn = homeFragment.findViewById(R.id.btn_stopOrchestra);
        orchestraPlayingTv = homeFragment.findViewById(R.id.tv_orchestra_playing);
        orchestraPlayingTv.setText(orchestraPlayingStatus);
        stopOrchestraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopOrchestra();
            }
        });

        // Handle orchestra playing
        Button orchestraPlayingBtn = homeFragment.findViewById(R.id.btn_playOrchestra);
        orchestraPlayingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playOrchestra();
            }
        });

        /////////////// Handle section enabling //////////////////
        // Handle strings section enabling
        stringsSwitchBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                System.out.println("Reached inside Strings Onchecked.");
                if (isChecked && mOrchestra != null)
                    mOrchestra.enableStrings();
                else if (mOrchestra != null)
                    mOrchestra.disableStrings();
                else
                    System.out.println("mOrchestra is null!!");
            }
        });

        // Handle woodwinds section enabling
        woodwindsSwitchBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked && mOrchestra != null)
                   mOrchestra.enableWoodwinds();
                else if (mOrchestra != null)
                    mOrchestra.disableWoodwinds();
            }
        });

        // Handle brasswinds section enabling
        brasswindsSwitchBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked && mOrchestra != null)
                    mOrchestra.enableBrasswinds();
                else if (mOrchestra != null)
                    mOrchestra.disableBrasswinds();
            }
        });

        // Handle percussions section enabling
        percussionsSwitchBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked && mOrchestra != null)
                   mOrchestra.enablePercussions();
                else if (mOrchestra != null)
                    mOrchestra.disablePercussions();
            }
        });
        return homeFragment;
    }

    private void playOrchestra() {
        mOrchestra.startOrchestra();
        mOrchestraViewModel.setLivePlayingStatus("PLAYING");
    }

    private void stopOrchestra() {
        mOrchestra.stopOrchestra();
        mOrchestra.setOrchestraVolume(0);
        int currVolume = mOrchestra.getOrchestraVolume();
        orchestraVolumeEt.setText(String.valueOf(currVolume));
        stringVolumeEt.setText(String.valueOf(currVolume));
        woodwindVolumeEt.setText(String.valueOf(currVolume));
        brasswindVolumeEt.setText(String.valueOf(currVolume));
        percussionVolumeEt.setText(String.valueOf(currVolume));
        mOrchestraViewModel.setLivePlayingStatus("STOPPED");
    }

    /////////////////////// Volume decrease helper methods //////

    private void decreaseOrchestraVolume() {
        int currVolume = mOrchestra.getOrchestraVolume();
        if (canDecreaseVolume(currVolume))
            currVolume--;
        else
            Toast.makeText(getContext(), "Min volume reached.", Toast.LENGTH_LONG).show();
        mOrchestra.setOrchestraVolume(currVolume);
        orchestraVolumeEt.setText(String.valueOf(currVolume));
        stringVolumeEt.setText(String.valueOf(currVolume));
        woodwindVolumeEt.setText(String.valueOf(currVolume));
        brasswindVolumeEt.setText(String.valueOf(currVolume));
        percussionVolumeEt.setText(String.valueOf(currVolume));
    }

    private void decreasePercussionVolume() {
        int currVolume = mOrchestra.getPercussionsVolume();
        if (canDecreaseVolume(currVolume))
            currVolume--;
        else
            Toast.makeText(getContext(), "Min volume reached.", Toast.LENGTH_LONG).show();
        mOrchestra.setPercussionsVolume(currVolume);
        percussionVolumeEt.setText(String.valueOf(currVolume));
        orchestraVolumeEt.setText(""); // Hide the orchestra volume
    }

    private void decreaseBrasswindVolume() {
        int currVolume = mOrchestra.getBrasswindsVolume();
        if (canDecreaseVolume(currVolume))
            currVolume--;
        else
            Toast.makeText(getContext(), "Min volume reached.", Toast.LENGTH_LONG).show();
        mOrchestra.setBrasswindsVolume(currVolume);
        brasswindVolumeEt.setText(String.valueOf(currVolume));
        orchestraVolumeEt.setText(""); // Hide the orchestra volume
    }

    private void decreaseWoodwindVolume() {
        int currVolume = mOrchestra.getWoodwindsVolume();
        if (canDecreaseVolume(currVolume))
            currVolume--;
        else
            Toast.makeText(getContext(), "Min volume reached.", Toast.LENGTH_LONG).show();
        mOrchestra.setWoodwindsVolume(currVolume);
        woodwindVolumeEt.setText(String.valueOf(currVolume));
        orchestraVolumeEt.setText(""); // Hide the orchestra volume
    }

    private void decreaseStringVolume() {
        int currVolume = mOrchestra.geStringsVolume();
        if (canDecreaseVolume(currVolume))
            currVolume--;
        else
            Toast.makeText(getContext(), "Min volume reached.", Toast.LENGTH_LONG).show();
        mOrchestra.setStringsVolume(currVolume);
        stringVolumeEt.setText(String.valueOf(currVolume));
        orchestraVolumeEt.setText(""); // Hide the orchestra volume
    }

    //////////////////////  Volume increase helper methods

    private void increaseOrchestraVolume() {
        int currVolume = mOrchestra.getOrchestraVolume();
        if (canIncreaseVolume(currVolume))
            currVolume++;
        else
            Toast.makeText(getContext(), "Max volume reached.", Toast.LENGTH_LONG).show();
        mOrchestra.setOrchestraVolume(currVolume);
        orchestraVolumeEt.setText(String.valueOf(currVolume));
        stringVolumeEt.setText(String.valueOf(currVolume));
        woodwindVolumeEt.setText(String.valueOf(currVolume));
        brasswindVolumeEt.setText(String.valueOf(currVolume));
        percussionVolumeEt.setText(String.valueOf(currVolume));
    }

    private void increasePercussionVolume() {
        int currVolume = mOrchestra.getPercussionsVolume();
        if (canIncreaseVolume(currVolume))
            currVolume++;
        else
            Toast.makeText(getContext(), "Max volume reached.", Toast.LENGTH_LONG).show();
        mOrchestra.setPercussionsVolume(currVolume);
        percussionVolumeEt.setText(String.valueOf(currVolume));
        orchestraVolumeEt.setText(""); // Hide the orchestra volume
    }

    private void increaseBrasswindVolume() {
        int currVolume = mOrchestra.getBrasswindsVolume();
        if (canIncreaseVolume(currVolume))
            currVolume++;
        else
            Toast.makeText(getContext(), "Max volume reached.", Toast.LENGTH_LONG).show();
        mOrchestra.setBrasswindsVolume(currVolume);
        brasswindVolumeEt.setText(String.valueOf(currVolume));
        orchestraVolumeEt.setText(""); // Hide the orchestra volume
    }

    private void increaseWoodwindVolume() {
        int currVolume = mOrchestra.getWoodwindsVolume();
        if (canIncreaseVolume(currVolume))
            currVolume++;
        else
            Toast.makeText(getContext(), "Max volume reached.", Toast.LENGTH_LONG).show();
        mOrchestra.setWoodwindsVolume(currVolume);
        woodwindVolumeEt.setText(String.valueOf(currVolume));
        orchestraVolumeEt.setText(""); // Hide the orchestra volume
    }

    private void increaseStringVolume() {
        int currVolume = mOrchestra.geStringsVolume();
        if (canIncreaseVolume(currVolume))
            currVolume++;
        else
            Toast.makeText(getContext(), "Max volume reached.", Toast.LENGTH_LONG).show();
        mOrchestra.setStringsVolume(currVolume);
        stringVolumeEt.setText(String.valueOf(currVolume));
        orchestraVolumeEt.setText(""); // Hide the orchestra volume
    }

    private boolean canDecreaseVolume(int currVolume) {
        return currVolume > 0 && currVolume <= 10;
    }

    private boolean canIncreaseVolume(int currVolume) {
        return currVolume >= 0 && currVolume < 10;
    }

    ////////////////////  Orchestra and section snapshot helper methods
    private void viewPercussionSnapshot() {
        mSnapshotViewModel.setSnapshot(mOrchestra.getPercussionSnapshot());
        Navigation.findNavController(getActivity(), R.id.host_fragment).navigate(R.id.snapshotFragment);
    }

    private void viewBrasswindsSnapshot() {
        mSnapshotViewModel.setSnapshot(mOrchestra.getBrasswindSnapshot());
        Navigation.findNavController(getActivity(), R.id.host_fragment).navigate(R.id.snapshotFragment);
    }

    private void viewWoodwindsSnapshot() {
        mSnapshotViewModel.setSnapshot(mOrchestra.getWoodwindSnapshot());
        Navigation.findNavController(getActivity(), R.id.host_fragment).navigate(R.id.snapshotFragment);
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
