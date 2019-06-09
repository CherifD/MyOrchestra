package com.cherifcodes.myorchestra.model;

import com.cherifcodes.myorchestra.model.instruments.InstrumentFactory;
import com.cherifcodes.myorchestra.model.sections.Section;
import com.cherifcodes.myorchestra.model.sections.SectionFactory;

public class Orchestra {
    private int orchestraVolume;
    private boolean isPlaying;
    private Section strings;
    private Section brasswinds;
    private Section percussions;
    private Section woodwinds;

    public Orchestra() {
        this.initStringsSection();
        this.initWoodwindsSection();
        this.initBrasswindsSection();
        this.initPercussionsSection();
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

    public void addStringInstrument(String instrumentName) {
        this.strings.addInstrument(InstrumentFactory.createInstrument(instrumentName,
                this.strings.getSectionName()));
    }

    public void addWoodwindInstrument(String instrumentName) {
        this.woodwinds.addInstrument(InstrumentFactory.createInstrument(instrumentName,
                this.woodwinds.getSectionName()));
    }

    public void addBrassInstrument(String instrumentName) {
        this.brasswinds.addInstrument(
                InstrumentFactory.createInstrument(instrumentName, this.brasswinds.getSectionName()));
    }

    public void addPercussionInstrument(String instrumentName) {
        this.percussions.addInstrument(InstrumentFactory.createInstrument(instrumentName,
                this.percussions.getSectionName()));
    }

    private void initStringsSection() {
        strings = SectionFactory.createSection(ModelConstants.STRINGS);
        addInstrumentsToSection(strings, "2nd violin", ModelConstants.INIT_NUM_2ND_VIOLINS);
        addInstrumentsToSection(strings, "1st violins", ModelConstants.INIT_NUM_1ST_VIOLINS);
        addInstrumentsToSection(strings, "viola", ModelConstants.INIT_NUM_VIOLAS);
        addInstrumentsToSection(strings, "cello", ModelConstants.INIT_NUM_CELLOS);
        addInstrumentsToSection(strings, "double bass", ModelConstants.INIT_NUM_DOUBLE_BASSES);
    }

    private void initWoodwindsSection() {
        woodwinds = SectionFactory.createSection(ModelConstants.WOODWINDS);
        addInstrumentsToSection(woodwinds, "clarinet", ModelConstants.INIT_NUM_CLARINETS);
        addInstrumentsToSection(woodwinds, "bassoon", ModelConstants.INIT_NUM_BASSOONS);
        addInstrumentsToSection(woodwinds, "flute", ModelConstants.INIT_NUM_FLUTES);
        addInstrumentsToSection(woodwinds, "oboe", ModelConstants.INIT_NUM_OBOES);
    }

    private void initBrasswindsSection() {
        brasswinds = SectionFactory.createSection(ModelConstants.BRASSWINDS);
        addInstrumentsToSection(brasswinds, "trumpet", ModelConstants.INIT_NUM_TRUMPETS);
        addInstrumentsToSection(brasswinds, "trombone", ModelConstants.INIT_NUM_TROMBONES);
        addInstrumentsToSection(brasswinds, "tuba", ModelConstants.INIT_NUM_TUBAS);
        addInstrumentsToSection(brasswinds, "French horn", ModelConstants.INIT_NUM_FRENCH_HORNS);
    }

    private void initPercussionsSection() {
        percussions = SectionFactory.createSection(ModelConstants.PERCUSSIONS);
        addInstrumentsToSection(percussions, "snare", ModelConstants.INIT_NUM_SNARES);
        addInstrumentsToSection(percussions, "bass drum", ModelConstants.INIT_NUM_BRASS_DRUMS);
        addInstrumentsToSection(percussions, "timpani", ModelConstants.INIT_NUM_TIMPANIS);
        addInstrumentsToSection(percussions, "piano", ModelConstants.INIT_NUM_PIANOS);
    }

    private void addInstrumentsToSection(Section sectionName, String instrumentName, int numInstruments) {
        for (int i = 0; i < numInstruments; i++) {
            sectionName.addInstrument(
                    InstrumentFactory.createInstrument(instrumentName, sectionName.getSectionName()));
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Welcome to the Garmin Orchestra!\n");
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
}
