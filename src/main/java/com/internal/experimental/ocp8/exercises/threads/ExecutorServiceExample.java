package com.internal.experimental.ocp8.exercises.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Michaelr on 16/04/2018.
 */
public class ExecutorServiceExample {
    public static void main(String... args) throws  InterruptedException{
        ExecutorService executorService = null;
        try{
            executorService = Executors.newFixedThreadPool(2);
            Runnable task = () -> System.out.println("Current thread name: " + Thread.currentThread().getName());
            task.run();
            new Thread(task).start();
            System.out.println("begin");
            executorService.execute(()-> {
                System.out.println("Current thread name: " + Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Execution 1");

            });
            //executorService.shutdown();
            executorService.execute(()-> {
                System.out.println("Current thread name: " + Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Execution 2");

            });
            executorService.execute(()-> {
                System.out.println("Current thread name: " + Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Execution 3");
            });
            System.out.println("end");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(executorService != null)
                executorService.shutdown();
        }
    }
}
