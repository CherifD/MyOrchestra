package com.cherifcodes.myorchestra.model;

import android.util.Log;

import com.cherifcodes.myorchestra.model.instruments.Instrument;
import com.cherifcodes.myorchestra.model.sections.Section;
import com.cherifcodes.myorchestra.model.sections.SectionFactory;

import java.util.List;

public class Orchestra {
    private List<? extends Instrument> instrumentList;
    private int orchestraVolume;
    private boolean isPlaying;
    private Section strings;
    private Section brasswinds;
    private Section percussions;
    private Section woodwinds;

    public Orchestra(List<? extends Instrument> instrumentList) {
        this.instrumentList = instrumentList;
        this.initSections();
    }

    public void initSections() {
        this.initStringsSection();
        this.initWoodwindsSection();
        this.initBrasswindsSection();
        this.initPercussionsSection();
        if (this.instrumentList != null) {
            for (Instrument instrument : this.instrumentList) {
                this.addInstrument(instrument);
            }
        } else {
            Log.i("Orchestra ", "!!!The Orchestra's instrument list is null!!!");
        }
    }

    public void setInstrumentList(List<? extends Instrument> instrumentList) {
        this.instrumentList = instrumentList;
        this.initSections();
    }

    public void enableStrings() {
        this.strings.setEnabled(true);
    }

    public void disableStrings() {
        this.strings.setEnabled(false);
    }

    public void enableWoodwinds() {
        this.woodwinds.setEnabled(true);
    }

    public void disableWoodwinds() {
        this.woodwinds.setEnabled(false);
    }

    public void enableBrasswinds() {
        this.brasswinds.setEnabled(true);
    }

    public void disableBrasswinds() {
        this.brasswinds.setEnabled(false);
    }

    public void enablePercussions() {
        this.percussions.setEnabled(true);
    }

    public void disablePercussions() {
        this.percussions.setEnabled(false);
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }

    public void startOrchestra() {
        this.isPlaying = true;
    }

    public void stopOrchestra() {
        this.isPlaying = false;
        // Disable all sections
        this.strings.setEnabled(false);
        this.woodwinds.setEnabled(false);
        this.brasswinds.setEnabled(false);
        this.percussions.setEnabled(false);
    }

    public void setOrchestraVolume(int newVolumeLevel) {
        this.orchestraVolume = newVolumeLevel;
        // Update all section volumes
        this.strings.setSectionVolume(newVolumeLevel);
        this.woodwinds.setSectionVolume(newVolumeLevel);
        this.brasswinds.setSectionVolume(newVolumeLevel);
        this.percussions.setSectionVolume(newVolumeLevel);
    }

    public int getOrchestraVolume() {
        return this.orchestraVolume;
    }

    public void setStringsVolume(int newVolumeLevel) {
        this.strings.setSectionVolume(newVolumeLevel);
    }

    public void setWoodwindsVolume(int newVolumeLevel) {
        this.woodwinds.setSectionVolume(newVolumeLevel);
    }

    public void setBrasswindsVolume(int newVolumeLevel) {
        this.brasswinds.setSectionVolume(newVolumeLevel);
    }

    public void setPercussionsVolume(int newVolumeLevel) {
        this.percussions.setSectionVolume(newVolumeLevel);
    }

    public void addInstrument(Instrument instrument) {
        if (instrument == null)
            throw new IllegalArgumentException("Instrument must not be null.");
        if (instrument.getInstrumentSection().equals(ModelConstants.STRINGS)) {
            this.strings.addInstrument(instrument);
        } else if (instrument.getInstrumentSection().equals(ModelConstants.WOODWINDS)) {
            this.woodwinds.addInstrument(instrument);
        } else if (instrument.getInstrumentSection().equals(ModelConstants.BRASSWINDS)) {
            this.brasswinds.addInstrument(instrument);
        } else if (instrument.getInstrumentSection().equals(ModelConstants.PERCUSSIONS)) {
            this.percussions.addInstrument(instrument);
        } else {
            throw new IllegalArgumentException("Invalid instrument section.");
        }
    }

    private void initStringsSection() {
        strings = SectionFactory.createSection(ModelConstants.STRINGS);
    }

    private void initWoodwindsSection() {
        woodwinds = SectionFactory.createSection(ModelConstants.WOODWINDS);
    }

    private void initBrasswindsSection() {
        brasswinds = SectionFactory.createSection(ModelConstants.BRASSWINDS);
    }

    private void initPercussionsSection() {
        percussions = SectionFactory.createSection(ModelConstants.PERCUSSIONS);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Welcome to the G-Orchestra!\n");
        if (this.isPlaying())
            stringBuilder.append("<<< The orchestra is now PLAYING!>>>\n");
        else
            stringBuilder.append("<<< The orchestra is not playing, right now.>>>\n");
        stringBuilder.append(this.strings.toString());
        stringBuilder.append(this.woodwinds.toString());
        stringBuilder.append(this.brasswinds.toString());
        stringBuilder.append(this.percussions.toString());
        return stringBuilder.toString();
    }

    public String getStringSnapshot() {
        return strings.toString();
    }

    public String getWoodwindSnapshot() {
        return woodwinds.toString();
    }

    public String getBrasswindSnapshot() {
        return brasswinds.toString();
    }

    public String getPercussionSnapshot() {
        return percussions.toString();
    }

    public int geStringsVolume() {
        return strings.getSectionVolume();
    }

    public int getWoodwindsVolume() {
        return woodwinds.getSectionVolume();
    }

    public int getBrasswindsVolume() {
        return brasswinds.getSectionVolume();
    }

    public int getPercussionsVolume() {
        return percussions.getSectionVolume();
    }
}
