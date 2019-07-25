package com.example.javarushTestTask.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Boolean necessary;
    private Integer amount;

    public Part() {
    }

    public Part(String name, Boolean necessary, Integer amount) {
        this.name = name;
        this.necessary = necessary;
        if(amount<=0){
        this.amount = 0;}
        else {
            this.amount = amount;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getNecessary() {
        return necessary;
    }

    public void setNecessary(Boolean necessary) {
        this.necessary = necessary;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        if(amount<=0){
            this.amount = 0;}
        else {
            this.amount = amount;
        }
    }
}
