package com.cherifcodes.myorchestra.model;

import java.util.List;

public abstract class Section {

    private String sectionName;
    private boolean isEnabled;
    private List<Instrument> instrumentList;

    public Section(String sectionName, List<Instrument> instrumentList) {
        this.sectionName = sectionName;
        this.instrumentList = instrumentList;
    }

    public String getSectionName() {
        return this.sectionName;
    }

    private void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    private boolean isEnabled() {
        return this.isEnabled;
    }

    private void validateList() {
        if (this.instrumentList == null || this.instrumentList.size() == 0)
            throw new IllegalArgumentException("There are no instruments in the list");
    }

    public void setSectionVolume(int newVolumeLevel) {
        this.validateList();

        for (Instrument instrument: this.instrumentList) {
            instrument.setVolumeLevel(newVolumeLevel);
        }
    }

    public void setInstrumentVolume(int instrumentId, int newVolumeLevel) {
        this.validateList();
        if (instrumentId < 0 || instrumentId >= this.instrumentList.size()) {
            throw new IllegalArgumentException("Invalid instrument ID.");
        }

        this.instrumentList.get(instrumentId).setVolumeLevel(newVolumeLevel);
    }
}
