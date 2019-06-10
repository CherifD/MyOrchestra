package com.cherifcodes.myorchestra.viewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.cherifcodes.myorchestra.model.ModelConstants;
import com.cherifcodes.myorchestra.model.Orchestra;

public class OrchestraViewModel extends AndroidViewModel {
    MutableLiveData<Orchestra> liveOrchestra;

    MutableLiveData<String> livePlayingStatus;

    public OrchestraViewModel(@NonNull Application application) {
        super(application);
        liveOrchestra = new MutableLiveData<>();
        liveOrchestra.setValue(new Orchestra());
        livePlayingStatus = new MutableLiveData<>();
    }

    public boolean addInstrument(String newInstrumentName, String section) {
        Orchestra orchestra = liveOrchestra.getValue();
        if (section.equals(ModelConstants.STRINGS)) {
            orchestra.addStringInstrument(newInstrumentName);
            return true;
        } else if (section.equals(ModelConstants.BRASSWINDS)) {
            orchestra.addBrassInstrument(newInstrumentName);
            return true;
        }else if ((section.equals(ModelConstants.WOODWINDS))) {
            orchestra.addWoodwindInstrument(newInstrumentName);
            return true;
        }else if (section.equals(ModelConstants.PERCUSSIONS)) {
            orchestra.addPercussionInstrument(newInstrumentName);
            return true;
        } else {
            return false;
        }

    }

    public void setLivePlayingStatus(String playingStatus) {
        this.livePlayingStatus.setValue(playingStatus);
    }

    public LiveData<String> getPlayingStatus() {
        return this.livePlayingStatus;
    }

    public LiveData<Orchestra> getOrchestra() {
        return liveOrchestra;
    }
}
