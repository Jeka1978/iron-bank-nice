package com.gameofthrones.ironbank;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import sun.net.ConnectionResetException;

/**
 * @author Evgeny Borisov
 */
@Component
public class RavenSenderListener implements ApplicationListener<ContextRefreshedEvent>{
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("this is my custom raven, I don't need any favours from your starter");
    }
}
