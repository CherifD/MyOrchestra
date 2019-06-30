package com.cherifcodes.myorchestra.model.instruments;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.PrimaryKey;
import android.text.TextUtils;

import com.cherifcodes.myorchestra.model.ModelConstants;

public abstract class Instrument {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "Name")
    private String instrumentName;
    @ColumnInfo(name = "Section")
    private String instrumentSection;

    private int volumeLevel;
    private boolean isEnabled;

    public Instrument(String instrumentName, String instrumentSection, int volumeLevel) {
        setInstrumentName(instrumentName);
        setInstrumentSection(instrumentSection);
        setVolumeLevel(volumeLevel);
    }

    public void setInstrumentName(String instrumentName) {
        if (TextUtils.isEmpty(instrumentName))
            throw new IllegalArgumentException("Invalid instrument name");
        this.instrumentName = instrumentName;
    }

    public void setInstrumentSection(String instrumentSection) {
        if (TextUtils.isEmpty(instrumentSection))
            throw new IllegalArgumentException("Instrument section cannot be a null or empty string");
        this.instrumentSection = instrumentSection;
    }

    public void setVolumeLevel(int newVolumeLevel) {
        if (newVolumeLevel < ModelConstants.MIN_VOLUME || newVolumeLevel > ModelConstants.MAX_VOLUME)
            throw new IllegalArgumentException("Volume level must be between 0 and 10");
        this.volumeLevel = newVolumeLevel;
    }

    public int getId() {
        return this.id;
    }

    public int getVolumeLevel() {
        return this.volumeLevel;
    }

    public void setId(int dbId) {
        this.id = dbId;
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
        stringBuilder.append(this.getId());
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
