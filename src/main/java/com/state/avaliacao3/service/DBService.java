package com.state.avaliacao3.service;

import com.state.avaliacao3.model.State;
import com.state.avaliacao3.model.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DBService {

    @Autowired
    private StateRepository stateRepository;

    public void instanciaBaseDados() {

    State state = new State ("Santa Catarina","Sul",new BigDecimal(3500800),"florianopolis",new BigDecimal(30500));
    State state1 = new State ("Rio Grande Do Sul","Sul",new BigDecimal(4500800),"porto alegre",new BigDecimal(50400));
    State state2 = new State ("Parana","Sul",new BigDecimal(2500800),"curitiba",new BigDecimal(40500));

    }
}
