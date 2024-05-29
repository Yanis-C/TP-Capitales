package com.capitales.eval.service;

import com.capitales.eval.db.Country;
import com.capitales.eval.db.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService implements CountriesSearch {

    @Autowired
    CountryRepository countryRepository;

    @Override
    public Country getRandomCountry() {
        return countryRepository.getRandomCountry();
    }

    @Override
    public Country getRandomCountry(Integer id_country_exclude) {
        if (id_country_exclude == null) {
            return countryRepository.getRandomCountry();
        } else {
            return countryRepository.getRandomCountryExclude(id_country_exclude);
        }
    }

    @Override
    public Optional<Country> findById(Integer id) {
        return countryRepository.findById(id);
    }
}
