package com.gameofthrones.ironbank.controllers;

import com.gameofthrones.ironbank.services.BankService;
import com.gameofthrones.ironbankstarternice.infra.config.ConditionalOnProd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Evgeny Borisov
 */
@RestController
@RequestMapping("/iron-bank/api")
public class BankController {
    @Autowired
    private BankService bankService;

    @GetMapping("/ping")
    public String ping() {
        return "Winter is Coming...";
    }

    @GetMapping("/loan") //since 4.3
//    @RequestMapping(method = RequestMethod.GET) before 4.3
    public String loan(@RequestParam("name") String name, @RequestParam("amount") Long amount) {
        long answer = bankService.loan(name, amount);
        if (answer == -1) {
            return "Loan Rejected, you will not survive the winter, or we don't have enough money";
        }
        else {
            return "Money was transfered, current bank balance: " + answer;
        }
    }

    @GetMapping("/deposit/{amount}")
    public String deposit(@PathVariable("amount") long amount) {
        bankService.deposit(amount);
        return "Toda Raba!";
    }


    @GetMapping("/asaf")
    public String asafMethod() {
        bankService.depositWithException();
        return "Problem...";
    }




}






