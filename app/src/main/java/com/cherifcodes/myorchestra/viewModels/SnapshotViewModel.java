package com.cherifcodes.myorchestra.viewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

public class SnapshotViewModel extends AndroidViewModel {
    private MutableLiveData<String> liveSnapshot;
    public SnapshotViewModel(@NonNull Application application) {
        super(application);
        liveSnapshot = new MutableLiveData<>();
    }

    public void setSnapshot(String snapshot) {
        this.liveSnapshot.setValue(snapshot);
    }

    public LiveData<String> getSnapshot() {
        return this.liveSnapshot;
    }
}
