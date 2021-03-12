package com.github.elcioishizuka.citiesapi.states;

import com.github.elcioishizuka.citiesapi.states.repository.StateRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/states")
public class StateResource {

    //Dependency Injection
    private final StateRepository stateRepository;
    private StateResource (final StateRepository stateRepository){
        this.stateRepository = stateRepository;
    }

    @GetMapping
    public Page<State> getAllStates(Pageable pageable){
        return stateRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<State> getStateById(@PathVariable Long id){
        return Optional
                .ofNullable(stateRepository.findById(id).get())
                .map(foundState -> ResponseEntity.ok().body(foundState))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
