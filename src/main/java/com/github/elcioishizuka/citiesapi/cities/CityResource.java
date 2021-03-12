package com.github.elcioishizuka.citiesapi.cities;


import com.github.elcioishizuka.citiesapi.cities.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cities")
public class CityResource {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping
    public Page<City> listAllCities(Pageable pageable){
        return cityRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCityById(@PathVariable Long id){
        return Optional
                .ofNullable(cityRepository.findById(id).orElse(null))
                .map(foundCity -> ResponseEntity.ok(foundCity))
                .orElseGet( () -> ResponseEntity.notFound().build());
    }


}
