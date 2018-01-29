package com.gameofthrones.ironbank.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author Evgeny Borisov
 */
@Service
@Profile("WINTER_IS_HERE")
//spring.profiles.active=WINTER_IS_HERE via cmd / or environment variables
public class WinterProphetService implements ProphetService {
    @Override
    public boolean willSurvive(String name) {
        return name.toLowerCase().contains("lanister");
    }
}
