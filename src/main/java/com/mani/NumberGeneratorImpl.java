package com.mani;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@PropertySource("classpath:game.properties")
public class NumberGeneratorImpl implements NumberGenerator {

    // == fields ==

    @Value("${maxNumber : 5}")
    public int maxNumber;

    @Value("${minNumber : 0}")
    public int minNumber;

    Random random = new Random();

    // == public methods ==
    @Override
    public int getMaxNumber() {
        return maxNumber;
    }

    @Override
    public int getMinNumber() {
        return minNumber;
    }

    @Override
    public int getFirstGeneratedNumber() {
        return random.nextInt(maxNumber-minNumber)+minNumber;
    }

    @Override
    public int getSecondGeneratedNumber() {
        return random.nextInt(maxNumber-minNumber)+minNumber;
    }
}