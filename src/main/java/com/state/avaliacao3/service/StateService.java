package com.state.avaliacao3.service;

import com.state.avaliacao3.model.State;
import com.state.avaliacao3.model.repository.StateRepository;
import com.state.avaliacao3.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class StateService {

    @Autowired
    StateRepository stateRepository;

    public Boolean itsValid(State state){
        if(state.getRegion().equals("Norte") || state.getRegion().equals("Nordeste") ||state.getRegion().equals("Sul")
                ||state.getRegion().equals("Sudeste")||state.getRegion().equals("Centro-Oeste")){
            return true;
        }else {
            return false;
        }
    }

    public State saveState(State state){
        stateRepository.save(state);
        return state;
    }


    public State putStateById(Long id,State formState) {

        State newState = findStateById(id);
        newState.setName(formState.getName());
        newState.setRegion(formState.getRegion());
        newState.setPopulation(formState.getPopulation());
        newState.setCapital(formState.getCapital());
        newState.setArea(formState.getArea());
        return stateRepository.save(newState);
    }

    public List<State> findAllStates() {
        List<State> states = stateRepository.findStateList();
        stateRepository.findAll();
        return states;
    }

    public void deleteStateById(Long id) {

        stateRepository.deleteById(id);
    }

    public State findStateById(Long id) {
        Optional<State> state = stateRepository.findById(id);
        return state.orElseThrow(()->new ObjectNotFoundException(
                "State Not Found !! ID : "+id+", Type : "+State.class.getName()));
    }


    public List<State> findAllStatesByRegion(String region) {
        List<State>state= stateRepository.findAllStateByRegion(region);

        return state;
    }

    public List<State> findAllCarsByPopulation(BigDecimal population) {
        List<State>state= stateRepository.findAllStateByPopulation(population);

        return state;
    }

    public List<State> findAllStateByArea(BigDecimal area) {
        List<State>state= stateRepository.findAllStateByArea(area);

        return state;
    }
}
