package com.example;

import java.util.List;

public class Lion {

    boolean hasMane;
    private final IFeline feline;
    private final IAnimal animal;

    public Lion(String sex, IFeline feline, IAnimal animal) throws Exception {
        this.feline = feline;
        this.animal = animal;
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - Самец или Самка");
        }
    }

    public int getKittens() {
        return feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return animal.getFood("Хищник");
    }
}
