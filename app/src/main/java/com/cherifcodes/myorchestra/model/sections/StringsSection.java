package com.cherifcodes.myorchestra.model.sections;

import com.cherifcodes.myorchestra.model.instruments.Instrument;

import java.util.List;

public class StringsSection extends Section {
    public StringsSection(String sectionName, List<Instrument> instrumentList) {
        super(sectionName, instrumentList);
    }
}
