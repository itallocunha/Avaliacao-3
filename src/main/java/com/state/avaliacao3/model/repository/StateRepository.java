package com.state.avaliacao3.model.repository;

import com.state.avaliacao3.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface StateRepository extends JpaRepository <State,Long> {

    @Query("SELECT obj FROM state obj WHERE obj.id!= null")
    List<State> findStateList();

    @Query("SELECT obj FROM state obj WHERE obj.region = :receivregion")
    List<State> findAllStateByRegion(@Param("receivregion") String receivregion);

    @Query("SELECT obj FROM state obj WHERE obj.population = :receivpopulation")
    List<State> findAllStateByPopulation(@Param("receivpopulation") BigDecimal population);

    @Query("SELECT obj FROM state obj WHERE obj.area = :receivarea")
    List<State> findAllStateByArea(@Param("receivarea") BigDecimal area);
}
