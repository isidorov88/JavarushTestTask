package com.example.javarushTestTask.domain;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String necessariness;
    private Integer amount;
    private Boolean isNecessary;

    public Part() {
    }

    public Part(String name, String necessariness, Integer amount, Boolean isNecessary) {
        this.name = name;
        this.necessariness = necessariness;
        this.amount = amount;
        this.isNecessary = necessariness.equals("Да");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNecessariness() {
        return necessariness;
    }

    public void setNecessariness(String necessariness) {
        this.necessariness = necessariness;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Boolean getNecessary() {
        return isNecessary;
    }

    public void setNecessary(Boolean necessary) {
        isNecessary = necessary;
    }
}
