package com.state.avaliacao3.model.repository;

import com.state.avaliacao3.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StateRepository extends JpaRepository <State,Long> {

    @Query("SELECT obj FROM state obj WHERE obj.id!= null")
    List<State> findStateList();


}
