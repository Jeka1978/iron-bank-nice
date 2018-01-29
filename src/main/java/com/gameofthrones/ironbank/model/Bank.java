package com.gameofthrones.ironbank.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Evgeny Borisov
 */
@Data
@Entity
@NoArgsConstructor
public class Bank {
    @Id
    @GeneratedValue
    private int id;

    private long amount;

    public Bank(long amount) {
        this.amount = amount;
    }
}






