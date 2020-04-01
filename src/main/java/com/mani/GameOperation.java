package com.mani;

public interface GameOperation {

    String generatedOperation();
    void setNumbers();
    void setOperation();
    String getOperation();
    int getFirstNumber();
    int getSecondNumber();
    void check(int number);
    void setRemaining(int remaining);
    void setCount(int count);
    int getRemaining();
    int getCount();
}
