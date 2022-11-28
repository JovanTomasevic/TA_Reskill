package com.projectname.e2e.tests.data.enums;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public enum Country {

    SERBIA("Serbia", "RS", "Serbia (Србија)"),
    SPAIN("Spain", "ES", "Spain (España)");

    private final String countryName;
    private final String twoLetterCountry;
    private final String countryNumberSelect;

    private Country(String countryName, String twoLetterCountry, String countryNumberSelect) {
        this.countryName = countryName;
        this.twoLetterCountry = twoLetterCountry;
        this.countryNumberSelect = countryNumberSelect;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getTwoLetterCountry() {
        return twoLetterCountry;
    }

    public String getCountryNumberSelect() {
        return countryNumberSelect;
    }

    public static Country getRandomCountry() {
        List<Country> countries = new ArrayList<>();
        countries.add(Country.SERBIA);
        countries.add(Country.SPAIN);
        return countries.get(RandomUtils.nextInt(0, countries.size() - 1));
    }
}
