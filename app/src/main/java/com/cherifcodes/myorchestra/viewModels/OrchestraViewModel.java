package com.cherifcodes.myorchestra.viewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.cherifcodes.myorchestra.model.Orchestra;

public class OrchestraViewModel extends AndroidViewModel {
    MutableLiveData<Orchestra> liveOrchestra;
   /* MutableLiveData<Integer> liveOrchestraVolume;
    MutableLiveData<Integer> liveStringsVolume;
    MutableLiveData<Integer> liveWoodwindsVolume;
    MutableLiveData<Integer> liveBrasswindsVolume;
    MutableLiveData<Integer> livePercussionsVolume;

    MutableLiveData<Boolean> liveOrchestraIsEnabled;
    MutableLiveData<Boolean> liveStringsIsEnabled;
    MutableLiveData<Boolean> liveWoodwindsIsEnabled;
    MutableLiveData<Boolean> liveBrasswindsIsEnabled;
    MutableLiveData<Boolean> livePercussionsIsEnabled;*/

    public OrchestraViewModel(@NonNull Application application) {
        super(application);
        liveOrchestra = new MutableLiveData<>();
        liveOrchestra.setValue(new Orchestra());

        /*liveOrchestraVolume = new MutableLiveData<>();
        liveStringsVolume = new MutableLiveData<>();
        liveWoodwindsVolume = new MutableLiveData<>();
        liveBrasswindsVolume = new MutableLiveData<>();
        livePercussionsVolume = new MutableLiveData<>();

        liveOrchestraIsEnabled = new MutableLiveData<>();
        liveStringsIsEnabled = new MutableLiveData<>();
        liveWoodwindsIsEnabled = new MutableLiveData<>();
        liveBrasswindsIsEnabled = new MutableLiveData<>();
        livePercussionsIsEnabled = new MutableLiveData<>();*/
    }

    /*public void setLiveOrchestraVolume(int liveOrchestraVolume) {
        this.liveOrchestraVolume.setValue(liveOrchestraVolume);
    }

    public LiveData<Integer> getLiveOrchestraVolume() {
        return this.liveOrchestraVolume;
    }

    public LiveData<Integer> getLiveStringsVolume() {
        return this.liveStringsVolume;
    }

    public LiveData<Integer> getLiveWoodwindsVolume() {
        return this.liveWoodwindsVolume;
    }

    public LiveData<Integer> getLiveBrasswindsVolume() {
        return this.liveBrasswindsVolume;
    }

    public LiveData<Integer> getLivePercussionsVolume() {
        return this.livePercussionsVolume;
    }
*/
    public LiveData<Orchestra> getOrchestra() {
        return liveOrchestra;
    }
}
