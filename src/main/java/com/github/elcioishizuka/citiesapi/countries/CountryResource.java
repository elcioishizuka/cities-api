package com.github.elcioishizuka.citiesapi.countries;

import com.github.elcioishizuka.citiesapi.countries.Country;
import com.github.elcioishizuka.citiesapi.countries.repository.CountryRepositoty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/countries")
public class CountryResource {

    // Dependency injection
    private CountryRepositoty repository;
    private CountryResource(CountryRepositoty repository){
        this.repository = repository;
    }

    // Alternative way for dependency injection
    //    @Autowired
    //    private CountryRepositoty repository;

    // Returns list of all countries
    //    @GetMapping("/countries")
    //    public List<Country> countries() {
    //        return repository.findAll();
    //    }

    // Using Pageable Interface in the findAll() method. Returns Page object.
    // For the query it will be necessary to change the endpoint format to
    // http://localhost:8080/v1/api/countries?page=0&size=10&sort=name,desc , for example.
    @GetMapping
    public Page<Country> countries(Pageable page) {
        return repository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getOne(@PathVariable Long id){

//        Code developed during the class
//        Optional<Country> foundCountry = repository.findById(id);
//        if (foundCountry.isPresent()){
//            return ResponseEntity.ok().body(foundCountry.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }

        // Alternative code replacing all the code above
        return Optional
                .ofNullable(repository.findById(id).get())
                .map(foundCountry -> ResponseEntity.ok().body(foundCountry))
                .orElseGet( () -> ResponseEntity.notFound().build());

    }


}
