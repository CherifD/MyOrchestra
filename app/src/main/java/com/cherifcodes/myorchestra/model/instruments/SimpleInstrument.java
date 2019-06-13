package com.cherifcodes.myorchestra.model.instruments;

import android.arch.persistence.room.Entity;

@Entity
public class SimpleInstrument extends Instrument {

    public SimpleInstrument(String instrumentName, String instrumentSection, int volumeLevel) {
        super(instrumentName, instrumentSection, volumeLevel);
    }

    public SimpleInstrument(String instrumentName, String instrumentSection) {
        this(instrumentName, instrumentSection, 0);
    }
}
