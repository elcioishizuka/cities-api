package com.github.elcioishizuka.citiesapi;

import com.github.elcioishizuka.citiesapi.countries.Country;
import com.github.elcioishizuka.citiesapi.repository.CountryRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("v1/api")
public class CountryResource {

    // Dependency injection
    private CountryRepositoty repository;
    private CountryResource(CountryRepositoty repository){
        this.repository = repository;
    }

    // Alternative way for dependency injection
    //    @Autowired
    //    private CountryRepositoty repository;

    @GetMapping("/countries")
    public List<Country> countries() {
        return repository.findAll();
    }

}
