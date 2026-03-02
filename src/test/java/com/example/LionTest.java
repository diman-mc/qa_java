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

    @Before
    public void setUp() throws Exception {
        lion = new Lion("Самец", feline, animal);
    }

    @Test(expected = Exception.class)
    public void lionExceptionTest() throws Exception {
        new Lion("Не самец и не самка", feline, animal);
    }

    @Test
    public void getKittensTest() {
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void doesHaveManeTest() {
        Assert.assertTrue(lion.doesHaveMane());
    }

    @Test
    public void getFoodTest() throws Exception {
        lion.getFood();
        Mockito.verify(animal).getFood("Хищник");
    }
}
