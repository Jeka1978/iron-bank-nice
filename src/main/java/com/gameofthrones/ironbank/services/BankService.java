package com.gameofthrones.ironbank.services;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

/**
 * @author Evgeny Borisov
 */
public interface BankService {

    long loan(String name, long amount);

    void addInitBalance();

    void deposit(long amount);

    void depositWithException();
}
