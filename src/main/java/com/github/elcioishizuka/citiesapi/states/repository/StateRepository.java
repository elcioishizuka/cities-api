package com.github.elcioishizuka.citiesapi.states.repository;

import com.github.elcioishizuka.citiesapi.states.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

}
