package com.mani;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Random;

@Slf4j
@Component
@PropertySource("classpath:game.properties")
public class GameOperationImpl implements GameOperation {

    // === fields ===
    String str[] = {"+","-","*","/"};
    int firstNumber;
    int secondNumber;
    String operation;
    Random random = new Random();

    @Value("${count:0}")
    int count;
    @Value("${remaining:5}")
    int remaining;

    @Autowired
    GameOperationPerform gameOperationPerform;

    @Autowired
    NumberGenerator numberGenerator;

    // == public methods ==
    @Override
    public String generatedOperation() {
        return str[random.nextInt(str.length)];
    }

    @Override
    public void setNumbers() {
        this.firstNumber = numberGenerator.getFirstGeneratedNumber();
        this.secondNumber = numberGenerator.getSecondGeneratedNumber();
    }

    @Override
    public void setOperation() {
        this.operation = generatedOperation();
    }

    @Override
    public String getOperation() {
        return operation;
    }

    @Override
    public int getFirstNumber() {
        return firstNumber;
    }
    @Override
    public int getSecondNumber() {
        return secondNumber;
    }
    @Override
    public void check(int number){
        if(number==gameOperationPerform.getGuessResult()){
            count++;
        }
        remaining--;
    }

    @Override
    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    @Override
    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public int getRemaining(){
        return remaining;
    }

    @Override
    public int getCount(){
        return count;
    }
}
