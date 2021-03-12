package com.github.elcioishizuka.citiesapi.cities.repository;

import com.github.elcioishizuka.citiesapi.cities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
