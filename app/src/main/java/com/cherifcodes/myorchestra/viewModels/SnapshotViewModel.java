package com.cherifcodes.myorchestra.viewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

public class SnapshotViewModel extends ViewModel {
    private MutableLiveData<String> liveSnapshot;
    public SnapshotViewModel() {
        liveSnapshot = new MutableLiveData<>();
    }

    public void setSnapshot(String snapshot) {
        liveSnapshot.setValue(snapshot);
    }

    public LiveData<String> getSnapshot() {
        return this.liveSnapshot;
    }
}
