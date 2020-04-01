package com.mani;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Configuration
public class AppConsole {

    // === fields ===
    @Autowired
    public GameOperation gameOperation;

    @Autowired
    public OperationConfig operationConfig;

    int number;

    Scanner sc = new Scanner(System.in);

    // === public methods ===
    @EventListener(ContextRefreshedEvent.class)
    public void start() {
        while (true) {
            operationConfig.configOperation();
            System.out.print("Enter answer : ");
            System.out.println(gameOperation.getFirstNumber() + " " + gameOperation.getOperation() + " " + gameOperation.getSecondNumber());
            number = sc.nextInt();
            sc.nextLine();
            gameOperation.check(number);
            if (gameOperation.getRemaining() <= 0) {
                System.out.println("Your Result is : " + gameOperation.getCount());
                System.out.println("You Want to Play Again ! (y/n)");
                String st = sc.nextLine();
                if (st.equalsIgnoreCase("y")) {
                    gameOperation.setCount(0);
                    gameOperation.setRemaining(5);
                } else {
                    break;
                }
            }
        }
    }
}