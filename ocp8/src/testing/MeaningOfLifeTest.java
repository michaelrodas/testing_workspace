package testing;

import exercises.patterns.MeaningOfLife;
import junit.framework.TestCase;

import java.lang.reflect.Constructor;

/**
 * Created by MichaelR on 14/02/2018.
 */
public class MeaningOfLifeTest extends TestCase {
    Constructor<?>[] constructors = null;
    public void testConstructor(){
        /*MeaningOfLife instance1 = MeaningOfLife.getInstance();
        instance1.getValue();
        MeaningOfLife instance2 = MeaningOfLife.getInstance();
        assertEquals(instance1.hashCode(),instance2.hashCode());*/
    }

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
