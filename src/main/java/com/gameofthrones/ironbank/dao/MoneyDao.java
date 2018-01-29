package com.gameofthrones.ironbank.dao;

import com.gameofthrones.ironbank.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Evgeny Borisov
 */
public interface MoneyDao extends JpaRepository<Bank,Integer> {
}
