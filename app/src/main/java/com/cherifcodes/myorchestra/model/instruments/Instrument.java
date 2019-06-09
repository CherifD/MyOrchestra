package com.cherifcodes.myorchestra.model.instruments;

import android.text.TextUtils;

import com.cherifcodes.myorchestra.model.ModelConstants;

import java.util.Arrays;

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
            throw new IllegalArgumentException("Instrument section cannot be a null or empty string");
        this.instrumentSection = instrumentSection;
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

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("A ");
        stringBuilder.append(getInstrumentName());
        stringBuilder.append(" with ID: ");
        stringBuilder.append(this.getInstrumentId());
        if (this.isEnabled()) {
            stringBuilder.append(" from the ");
            stringBuilder.append(this.getInstrumentSection());
            stringBuilder.append(" section that is playing at Volume: ");
            stringBuilder.append(getVolumeLevel());
            stringBuilder.append("\n");
            return stringBuilder.toString();
        }
        stringBuilder.append(" and Volume: ");
        stringBuilder.append(this.getVolumeLevel());
        stringBuilder.append(" from the ");
        stringBuilder.append(getInstrumentSection());
        stringBuilder.append(" section, but that is not enabled yet.\n");
        return stringBuilder.toString();
    }
}
