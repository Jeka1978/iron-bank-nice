package com.gameofthrones.ironbank.services;

import com.gameofthrones.ironbank.dao.MoneyDao;
import com.gameofthrones.ironbank.model.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Evgeny Borisov
 */
@Service
@Transactional
public class BankServiceImpl implements BankService {
    @Autowired
    private MoneyDao moneyDao;
    @Autowired
    private ProphetService prophetService;

    @Override
    public long loan(String name, long amount) {
        Bank bank = moneyDao.findAll().get(0);
        if (bank.getAmount() > amount && prophetService.willSurvive(name)) {
            bank.setAmount(bank.getAmount() - amount);
            moneyDao.save(bank);
            return bank.getAmount();
        }
        return -1;
    }

    @Override
    @EventListener(ContextRefreshedEvent.class)
    public void addInitBalance() {
        Bank bank = new Bank(100_000);
        moneyDao.save(bank);

    }

    @Override
    public void deposit(long amount) {

        Bank bank = moneyDao.findAll().get(0);
        bank.setAmount(bank.getAmount() + amount);
    }

    @Override
    public void depositWithException() {
        Bank bank = moneyDao.findAll().get(0);
        bank.setAmount(666);
        throw new IllegalStateException("can't use such a number, go to hell");
    }
}
