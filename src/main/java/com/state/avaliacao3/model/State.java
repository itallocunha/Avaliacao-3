package com.state.avaliacao3.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "state")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false,length = 20)
    private String name;
    @Column(name = "region", nullable = false,length = 20)
    private String region;
    @Column(name = "population", nullable = false,length = 20)
    private BigDecimal population;
    @Column(name = "capital", nullable = false,length = 20)
    private String capital;
    @Column(name = "area", nullable = false,length = 20)
    private BigDecimal area;

    public State(){

    }

    public State(String name, String region, BigDecimal population,String capital, BigDecimal area){
    this.name = name;
    this.region = region;
    this.population =population;
    this.capital = capital;
    this.area = area;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public BigDecimal getPopulation() {
        return population;
    }

    public void setPopulation(BigDecimal population) {
        this.population = population;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public State orElseThrow(Object o) {
        State state = new State();

        return state;
    }
}