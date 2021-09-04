package com.state.avaliacao3.controller;

import com.state.avaliacao3.model.State;
import com.state.avaliacao3.service.DBService;
import com.state.avaliacao3.service.StateService;
import com.state.avaliacao3.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/states")
public class mainController {

    @Autowired
    StateService stateService;

    @Autowired
    DBService dbService;

    @PostMapping("/")
    public ResponseEntity <State> postNewCar(@RequestBody State stateForm) throws ParseException {
        boolean right = stateService.itsValid(stateForm);

        if (right==true){
            State state = stateService.saveState(stateForm);
            return ResponseEntity.ok().body(state);
        }else{
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity <State> putStateById(@PathVariable Long id, @RequestBody State formState) throws ParseException{
        State state = stateService.putStateById(id,formState);
        return ResponseEntity.ok().body(state);
    }

    @GetMapping("/")
    public ResponseEntity<List<State>> listAllStates() throws ParseException {
       dbService.instanciaBaseDados();
        List<State> listStates = stateService.findAllStates();
        return ResponseEntity.ok().body(listStates);
    }

    @GetMapping("/{id}")
    public ResponseEntity <State> listStateById(@PathVariable Long id) throws ParseException {
        State state = stateService.findStateById(id);
        return ResponseEntity.ok().body(state);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <List<State>> deleteAllCars(@PathVariable Long id) throws ParseException {
        stateService.deleteStateById(id);
        List<State> listState = stateService.findAllStates();
        return ResponseEntity.ok().body(listState);
    }



}
