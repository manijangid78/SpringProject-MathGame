package com.mani;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperationConfig {

    @Autowired
    GameOperation gameOperation;

    public void configOperation(){
        gameOperation.setOperation();
        gameOperation.setNumbers();
    }
}
