package com.github.elcioishizuka.citiesapi.countries.repository;

import com.github.elcioishizuka.citiesapi.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepositoty extends JpaRepository<Country, Long> {

}
