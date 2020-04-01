package com.mani;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameOperationPerform {

    // == fields ==
    @Autowired
    public GameOperation gameOperation;


    // === public methods ===
    public int getGuessResult(){
        if(gameOperation.getOperation()=="+"){
            return gameOperation.getFirstNumber()+ gameOperation.getSecondNumber();
        } else if(gameOperation.getOperation()=="-"){
            return gameOperation.getFirstNumber() - gameOperation.getSecondNumber();
        } else if(gameOperation.getOperation()=="*"){
            return gameOperation.getFirstNumber() * gameOperation.getSecondNumber();
        } else {
            try {
                return gameOperation.getFirstNumber() / gameOperation.getSecondNumber();
            }
            catch (Exception e){}
        }
        return 0;
    }

}
