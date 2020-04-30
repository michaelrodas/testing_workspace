package com.internal.experimental.ocp8.exercises.patterns;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

/**
 * Created by MichaelR on 14/02/2018.
 */
public class MeaningOfLifeTest  {
    Constructor<?>[] constructors = null;

    @Test
    public void testConstructor(){
        /*MeaningOfLife instance1 = MeaningOfLife.getInstance();
        instance1.getValue();
        MeaningOfLife instance2 = MeaningOfLife.getInstance();
        assertEquals(instance1.hashCode(),instance2.hashCode());*/
    }

    @Test
    public void testMultithread(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                MeaningOfLife.getInstance();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                MeaningOfLife.getInstance();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                MeaningOfLife.getInstance();
            }
        }).start();

    }
}
