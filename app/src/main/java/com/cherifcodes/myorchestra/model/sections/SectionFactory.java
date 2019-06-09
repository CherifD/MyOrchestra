package com.cherifcodes.myorchestra.model.sections;

import com.cherifcodes.myorchestra.model.ModelConstants;

public class SectionFactory {

    /**
     * Creates a Section object based on a specified section name
     * @param sectionName the specified section name, which must be one of the section names
     *                    constants listed in ModelConstants.
     * @return a Section object if sectionName equals a valid section constant.
     * @throws IllegalArgumentException if sectionName is not a valid section constant.
     */
    public static Section createSection(String sectionName) {
        switch (sectionName) {
            case ModelConstants.PERCUSSIONS:
                return new PercussionsSection(sectionName, null);
            case ModelConstants.BRASSWINDS:
                return new BrasswindsSection(sectionName, null);
            case ModelConstants.WOODWINDS:
                return new WoodwindsSection(sectionName, null);
            case ModelConstants.STRINGS:
                return new StringsSection(sectionName, null);
        }
        throw new IllegalArgumentException(sectionName + " is not a valid section constant.");
    }
}
