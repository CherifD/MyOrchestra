package com.cherifcodes.myorchestra.model;

public class SimpleInstrument extends Instrument {

    public SimpleInstrument(String instrumentName, String instrumentSection, int volumeLevel) {
        super(instrumentName, instrumentSection, volumeLevel);
    }

    public SimpleInstrument(String instrumentName, String instrumentSection) {
        this(instrumentName, instrumentSection, 0);
    }

    @Override
    public String toString() {
        return "A " + getInstrumentName() + " from the " + getInstrumentSection() + " section " +
                "playing at volume " + getVolumeLevel();
    }
}
