package com.capitales.eval.service;

import com.capitales.eval.db.Country;
import java.util.Optional;

public interface CountriesSearch {

    public Country getRandomCountry();
    public Country getRandomCountry(Integer id_country_exclude);
    public Optional<Country> findById(Integer id);

}
