package com.example;

import java.util.List;

public class Lion {

    private final CatFamily catFamily;
    private final boolean hasMane;

    public Lion(String sex, CatFamily catFamily) throws Exception {
        this.catFamily = catFamily;
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }


    public int getKittens() {
        return catFamily.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return catFamily.getFood();
    }
}
