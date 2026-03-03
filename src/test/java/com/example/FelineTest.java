package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Spy
    private Feline feline = new Feline();

    @Test
    public void getFamilyTest() {
        String actualFamily = feline.getFamily();
        Assert.assertEquals("Кошачьи", actualFamily);
    }

    @Test
    public void getKittensWithoutParams() {
        int actualKittens = feline.getKittens();
        Assert.assertEquals(1, actualKittens);
    }

    @Test
    public void getKittensWithParamsInt() {
        int kittensCount = 5;
        int actualKittens = feline.getKittens(kittensCount);
        Assert.assertEquals(kittensCount, actualKittens);
    }
}
