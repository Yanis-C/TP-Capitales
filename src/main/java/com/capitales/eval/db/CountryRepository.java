package com.capitales.eval.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

    @Query(value = "SELECT * FROM countries ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Country getRandomCountry();

    @Query(value = "SELECT * FROM countries WHERE id != :id_country_exclude ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Country getRandomCountryExclude(@Param("id_country_exclude") Integer id_country_exclude);

}
