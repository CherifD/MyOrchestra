package com.cherifcodes.myorchestra.model.sections;

import android.text.TextUtils;

import com.cherifcodes.myorchestra.model.ModelConstants;
import com.cherifcodes.myorchestra.model.instruments.Instrument;

import java.util.ArrayList;
import java.util.List;

public abstract class Section {

    private String sectionName;
    private boolean isEnabled;
    private int sectionVolume;
    private List<Instrument> instrumentList;

    public Section(String sectionName, List<Instrument> instrumentList) {
        setSectionName(sectionName);
        setInstrumentList(instrumentList);
    }

    public Section(String sectionName) {
        this(sectionName, null);
    }

    private void setInstrumentList(List<Instrument> instrumentList) {
        if (instrumentList == null)
            this.instrumentList = new ArrayList<>();
        else
            this.instrumentList = instrumentList;
    }

    private void setSectionName(String sectionName) {
        if (TextUtils.isEmpty(sectionName))
            throw new IllegalArgumentException("Instrument section cannot be a null or empty string");

        // Validate sectionName before setting it.
        for (String section : ModelConstants.VALID_SECTIONS) {
            if (section.equals(sectionName))
                this.sectionName = sectionName;
            return;
        }
        throw new IllegalArgumentException("Invalid section name.");
    }

    public String getSectionName() {
        return this.sectionName;
    }

    public int getSectionVolume() {return this.sectionVolume;}

    public void setSectionVolume(int newVolumeLevel) {
        this.validateInstrumentList();
        this.validateVolume(newVolumeLevel);

        this.sectionVolume = newVolumeLevel; // Update section volume
        // Update volume of all instruments in this section
        for (Instrument instrument: this.instrumentList) {
            instrument.setVolumeLevel(newVolumeLevel);
        }
    }

    private void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    private boolean isEnabled() {
        return this.isEnabled;
    }

    public void setInstrumentVolume(int instrumentId, int newVolumeLevel) {
        this.validateInstrumentList();
        this.validateVolume(newVolumeLevel);

        // Find instrument ID from the list and set its volume
        for (Instrument instrument : instrumentList) {
            if (instrument.getInstrumentId() == instrumentId)
                instrument.setVolumeLevel(newVolumeLevel);
            return;
        }
        throw new IllegalArgumentException("Instrument ID: " + instrumentId +
                " is not on the list.");
    }

    /**
     * Adds a specified Instrument to this section's instrument list if their section names
     * are equal.  Nothing happens if the section names are different.
     * @param newInstrument the specified Instrument to add.
     */
    public void addInstrument(Instrument newInstrument) {
        // Note: No need to check for null instrumentList since it should have been already
        // initialized in the constructor
        if (!newInstrument.getInstrumentSection().equals(this.sectionName)) {
            this.instrumentList.add(newInstrument);
        }
    }

    /**
     * Removes from this section, the instrument that has the specified instrument ID
     * @param instrumentId the specified instrument's ID
     */
    public void removeInstrument(int instrumentId) {
        // Note: this method would be more efficient if List<Instrument> is replaced with
        // HashMap<InstrumentId, Instrument>.
        for (int i = 0; i < this.instrumentList.size(); i++) {
            if (this.instrumentList.get(i).getInstrumentId() == instrumentId) {
                this.instrumentList.remove(i);
                return;
            }
        }
    }

    private void validateVolume(int newVolumeLevel) {
        if (newVolumeLevel < ModelConstants.MIN_VOLUME || newVolumeLevel > ModelConstants.MAX_VOLUME)
            throw new IllegalArgumentException("Volume level must be between 0 and 10 inclusive");
    }

    /**
     * Ensures that the instrumentList has at least one item in it.
     */
    private void validateInstrumentList() {
        if (this.instrumentList == null || this.instrumentList.size() == 0)
            throw new IllegalArgumentException("There are no instruments in the list");
    }

    public String toString() {
        StringBuilder sectionStatus = new StringBuilder("**** The " + this.getSectionName());
        if (this.instrumentList.size() > 0) {
            this.createOnOffVersionsOfToString(sectionStatus);
            sectionStatus.append(" -It contains the following instruments:\n");
            for (Instrument instrument : this.instrumentList) {
                sectionStatus.append( "    -" + instrument.toString());
            }

        } else { // instrumentList is null or has no elements
            this.createOnOffVersionsOfToString(sectionStatus);
            sectionStatus.append(" - It has no instruments yet.");
        }
        sectionStatus.append("\n\n\n");
        return sectionStatus.toString();
    }

    /**
     * A helper method to format the section's toString() output depending on whether the section is
     * enabled or disabled.
     * @param stringBuilder the StringBuilder object used to create the output string
     */
    private void createOnOffVersionsOfToString(StringBuilder stringBuilder) {
        if (this.isEnabled())
            stringBuilder.append(" is ON!!\n");
        else // The section is not enabled
            stringBuilder.append(" is OFF.\n");

        stringBuilder.append(" -It's volume is set to: " + this.sectionVolume + "\n");
    }
}
