package com.example;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)

public class LionParametrizedTest {
    private final String sex;
    private final boolean hasMane;

    public LionParametrizedTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Rule
    public MockitoRule rule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

    @Mock
    IFeline feline;
    IAnimal animal;

    @Test
    public void lionConstructorTest() throws Exception {
        Lion lion = new Lion(sex, feline, animal);
        assertEquals(hasMane, lion.hasMane);
    }
}
