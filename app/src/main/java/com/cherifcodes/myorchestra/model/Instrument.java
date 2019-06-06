package com.cherifcodes.myorchestra.model;

public abstract class Instrument {
    private String instrumentName;
    private String instrumentSection;
    private int volumeLevel;

    public Instrument(String instrumentName, String instrumentSection, int volumeLevel) {
        this.instrumentName = instrumentName;
        this.instrumentSection = instrumentSection;
        this.setVolumeLevel(volumeLevel);
    }

    public void setVolumeLevel(int newVolumeLevel) {
        this.volumeLevel = newVolumeLevel;
    }

    public int getVolumeLevel() {
        return this.volumeLevel;
    }

    public String getInstrumentName() {
        return this.instrumentName;
    }

    public String getInstrumentSection() {
        return this.instrumentSection;
    }

    public abstract String toString();
}
