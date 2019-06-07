package com.cherifcodes.myorchestra.model.instruments;

import android.text.TextUtils;

import com.cherifcodes.myorchestra.model.ModelConstants;

public class InstrumentFactory {

    /**
     * Creates an instrument from the specified instrument name and section.
     * @param name the instrument's name
     * @param section the section where the instrument belongs. Has to be either woodwinds, brasswinds,
     *                percussions, 1st violins, 2nd violins, viola, cellos or double basses
     *
     * @return an Instrument instance if name and section are valid
     * @throws IllegalArgumentException if name or sections is invalid
     */
    public static Instrument createInstrument(String name, String section) {

        if (!isValidSection(section) || !isValidName(name))
            throw new IllegalArgumentException("Invalid instrument name or section");

        return new SimpleInstrument(name, section);
    }

    /**
     * Validates the specified instrument section
     * @param section the specified section
     * @return true if section is valid false otherwise
     */
    private static boolean isValidSection(String section) {
        if (TextUtils.isEmpty(section))
            return false;

        // Ensure that section is in the list of valid sections
        for (String str: ModelConstants.VALID_SECTIONS) {
            if (str.equals(section))
                return true;
        }

        return false; // if this line is reached, section is not in the list of valid sections

    }

    /**
     * Validates the specified instrument name, which cannot be null or the empty string.
     * @param instrumentName the instrument's name
     * @return true if instrumentName is valid, false otherwise
     */
    private static boolean isValidName(String instrumentName) {
        return !TextUtils.isEmpty(instrumentName);
    }
}
