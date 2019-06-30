package com.cherifcodes.myorchestra.viewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.cherifcodes.myorchestra.model.ModelConstants;
import com.cherifcodes.myorchestra.model.Orchestra;
import com.cherifcodes.myorchestra.model.database.Repository;
import com.cherifcodes.myorchestra.model.instruments.InstrumentFactory;
import com.cherifcodes.myorchestra.model.instruments.SimpleInstrument;

import java.util.List;

public class OrchestraViewModel extends AndroidViewModel {
    MutableLiveData<Orchestra> liveOrchestra;
    Repository repository;
    MutableLiveData<List<SimpleInstrument>> liveInstrumentList = new MutableLiveData<>();
    MutableLiveData<String> livePlayingStatus;
    MutableLiveData<Boolean> resetAppStatus;

    public OrchestraViewModel(@NonNull Application application) {
        super(application);
        repository = Repository.getInstance(application);

        liveOrchestra = new MutableLiveData<>();
        liveOrchestra.setValue(new Orchestra(null));

        liveInstrumentList.setValue(repository.getAllInstruments().getValue());

        livePlayingStatus = new MutableLiveData<>();
        resetAppStatus = new MutableLiveData<>();
    }

    public void addInstrument(String newInstrumentName, String section) {
        if (isValidSection(section)) {
            repository.insertSimpleInstrument(
                    InstrumentFactory.createInstrument(newInstrumentName, section));
            // NOT efficient to reload the entire list!!
            // Reset the orchestra and the playing status
            liveOrchestra.getValue().setInstrumentList(repository.getAllInstruments().getValue());
            livePlayingStatus.setValue(ModelConstants.STOPPED);
        }
    }

    public boolean isValidSection(String section) {
        return section.equals(ModelConstants.STRINGS) ||
                section.equals(ModelConstants.WOODWINDS) ||
                section.equals(ModelConstants.BRASSWINDS) ||
                section.equals(ModelConstants.PERCUSSIONS);
    }

    public void setLivePlayingStatus(String playingStatus) {
        this.livePlayingStatus.setValue(playingStatus);
    }

    public LiveData<Boolean> getResetAppStatus() {
        return this.resetAppStatus;
    }

    public void setResetAppStatus(boolean resetAppStatus) {
        this.resetAppStatus.setValue(resetAppStatus);
    }

    public LiveData<List<SimpleInstrument>> getAllInstruments() {
        return repository.getAllInstruments();
    }

    public LiveData<String> getPlayingStatus() {
        return this.livePlayingStatus;
    }

    public LiveData<Orchestra> getOrchestra() {
        return liveOrchestra;
    }
}
