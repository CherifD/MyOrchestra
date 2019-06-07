package com.cherifcodes.myorchestra.model.instruments;

import android.text.TextUtils;

import com.cherifcodes.myorchestra.model.ModelConstants;

public abstract class Instrument {
    private static int idTracker;
    private int id;
    private String instrumentName;
    private String instrumentSection;
    private int volumeLevel;
    private boolean isEnabled;

    public Instrument(String instrumentName, String instrumentSection, int volumeLevel) {
        setInstrumentName(instrumentName);
        setInstrumentSection(instrumentSection);
        setVolumeLevel(volumeLevel);
        Instrument.idTracker++;
        this.id = Instrument.idTracker;
    }

    private void setInstrumentName(String instrumentName) {
        if (TextUtils.isEmpty(instrumentName))
            throw new IllegalArgumentException("Invalid instrument name");
        this.instrumentName = instrumentName;
    }

    private void setInstrumentSection(String instrumentSection) {
        if (TextUtils.isEmpty(instrumentSection))
            throw new IllegalArgumentException("Instrument section cannot be null or empty string");

        // Validate instrument section before setting it.
        for (String sectionName : ModelConstants.VALID_SECTIONS) {
            if (sectionName.equals(instrumentSection))
                this.instrumentSection = instrumentSection;
            return;
        }
        throw new IllegalArgumentException("Invalid section name.");
    }

    public void setVolumeLevel(int newVolumeLevel) {
        if (newVolumeLevel < ModelConstants.MIN_VOLUME || newVolumeLevel > ModelConstants.MAX_VOLUME)
            throw new IllegalArgumentException("Volume level must be between 0 and 10");
        this.volumeLevel = newVolumeLevel;
    }

    public int getVolumeLevel() {
        return this.volumeLevel;
    }

    public int getInstrumentId() {
        return this.id;
    }

    public String getInstrumentName() {
        return this.instrumentName;
    }

    public String getInstrumentSection() {
        return this.instrumentSection;
    }

    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public abstract String toString();
}
