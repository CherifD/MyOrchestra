package com.cherifcodes.myorchestra.viewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.cherifcodes.myorchestra.model.Orchestra;

public class OrchestraViewModel extends AndroidViewModel {
    MutableLiveData<Orchestra> liveOrchestra;

    MutableLiveData<String> livePlayingStatus;

    public OrchestraViewModel(@NonNull Application application) {
        super(application);
        liveOrchestra = new MutableLiveData<>();
        liveOrchestra.setValue(new Orchestra());

        livePlayingStatus = new MutableLiveData<>();
        this.setLivePlayingStatus("STOPPED"); // Initialize the playing status string
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
