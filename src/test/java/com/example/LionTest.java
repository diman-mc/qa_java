package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private IFeline feline;

    @Mock
    private IAnimal animal;

    private Lion lion;

    @Test(expected = Exception.class)
    public void lionExceptionTest() throws Exception {
        new Lion("Не самец и не самка", feline, animal);
    }

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion("Самец", feline, animal);
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void doesHaveManeTest_Male() throws Exception {
        Lion maleLion = new Lion("Самец", feline, animal);
        Assert.assertTrue(maleLion.doesHaveMane());
    }

    @Test
    public void doesHaveManeTest_Female() throws Exception {
        Lion femaleLion = new Lion("Самка", feline, animal);
        Assert.assertFalse(femaleLion.doesHaveMane());
    }

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion("Самец", feline, animal);
        lion.getFood();
        Mockito.verify(animal).getFood("Хищник");
    }
}
