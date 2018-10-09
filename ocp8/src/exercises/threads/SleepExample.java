package exercises.threads;

/**
 * Created by Michaelr on 16/04/2018.
 */
public class SleepExample {
    private static int counter = 0;
    public static void main(String... args) throws InterruptedException{
        new Thread(() -> {
            for(int i=0;i<500;i++){
            SleepExample.counter++;
        }
        }).start();
        while (SleepExample.counter<100){
            System.out.println("Not reached yet" + " counter=" + SleepExample.counter);
            Thread.sleep(1000);
        }
        System.out.println("Reached!" + " counter=" + SleepExample.counter);
    }
}
