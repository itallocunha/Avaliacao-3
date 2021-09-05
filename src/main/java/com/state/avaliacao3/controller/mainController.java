package com.state.avaliacao3.controller;

import com.state.avaliacao3.model.State;
import com.state.avaliacao3.service.DBService;
import com.state.avaliacao3.service.StateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/states")
@Api(value= "API REST states")
@CrossOrigin(origins="*")
public class mainController {

    @Autowired
    StateService stateService;

    @Autowired
    DBService dbService;

    @PostMapping("/")
    @ApiOperation(value="Salva um states")
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
    @ApiOperation(value="Atualiza um state")
    public ResponseEntity <State> putStateById(@PathVariable Long id, @RequestBody State formState) throws ParseException{

        boolean right = stateService.itsValid(formState);

        if (right==true){
            State state = stateService.putStateById(id,formState);
            return ResponseEntity.ok().body(state);
        }else{
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    @ApiOperation(value="Returna uma lista de states")
    public ResponseEntity<List<State>> listAllStates() throws ParseException {
       dbService.instanciaBaseDados();
        List<State> listStates = stateService.findAllStates();
        return ResponseEntity.ok().body(listStates);
    }

    @GetMapping("/{id}")
    @ApiOperation(value="Retorna um unico state")
    public ResponseEntity <State> listStateById(@PathVariable Long id) throws ParseException {
        State state = stateService.findStateById(id);
        return ResponseEntity.ok().body(state);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="Deleta uma lista de states")
    public ResponseEntity <List<State>> deleteAllState(@PathVariable Long id) throws ParseException {
        stateService.deleteStateById(id);
        List<State> listState = stateService.findAllStates();
        return ResponseEntity.ok().body(listState);
    }

    @GetMapping("/region/{region}")
    @ApiOperation(value="Retorna regiao")
    public ResponseEntity <List<State>> listAllStateByRegion(@PathVariable String region) throws ParseException {
        List<State> listState = stateService.findAllStatesByRegion(region);
        return ResponseEntity.ok().body(listState);
    }

    @GetMapping("/population/{population}")
    @ApiOperation(value="Retorna populacao")
    public ResponseEntity <List<State>> listAllStateByPopulation(@PathVariable BigDecimal population) throws ParseException {
        List<State> listState = stateService.findAllCarsByPopulation(population);
        return ResponseEntity.ok().body(listState);
    }
    @GetMapping("/color/{color}")
    @ApiOperation(value="Retorna cor")
    public ResponseEntity <List<State>> listAllStateByArea(@PathVariable BigDecimal area) throws ParseException {
        List<State> listArea = stateService.findAllStateByArea(area);
        return ResponseEntity.ok().body(listArea);

    }
}
