package com.cherifcodes.myorchestra.model.instruments;

public class SimpleInstrument extends Instrument {

    public SimpleInstrument(String instrumentName, String instrumentSection, int volumeLevel) {
        super(instrumentName, instrumentSection, volumeLevel);
    }

    public SimpleInstrument(String instrumentName, String instrumentSection) {
        this(instrumentName, instrumentSection, 0);
    }

    @Override
    public String toString() {
        if (this.isEnabled())
            return "A " + getInstrumentName() + " with ID: " + this.getInstrumentId()+ " from the "
                    + getInstrumentSection() + " section " + "playing at volume " + getVolumeLevel();
        return "A " + getInstrumentName() + " with ID: " + this.getInstrumentId() + " and volume: "
                + this.getVolumeLevel() + " from the " + getInstrumentSection() + " section, but " +
                "that is not enabled yet";
    }
}
