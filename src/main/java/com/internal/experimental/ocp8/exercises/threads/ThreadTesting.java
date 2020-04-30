package com.internal.experimental.ocp8.exercises.threads;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Michaelr on 16/04/2018.
 */
public class ThreadTesting {
    public static void main(String... args) {
        ExecutorService executorService = null;
        try{
            executorService = //Executors.newSingleThreadExecutor();
             Executors.newFixedThreadPool(10);

            Runnable runnableTask = () -> {
                try {
                    System.out.println("Running Runnable");
                    TimeUnit.MILLISECONDS.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };

            Callable<String> callableTask = () -> {
                //TimeUnit.MILLISECONDS.sleep(9000);
                return "Callable Task's execution";
            };
            /*
            List<Callable<String>> callableTasks = new ArrayList<>();
            callableTasks.add(callableTask);
            callableTasks.add(callableTask);
            callableTasks.add(callableTask);
            */
            List<Callable<String>> callableTasks = Arrays.asList(
                    () -> "task1",
                    () -> {TimeUnit.SECONDS.sleep(5); return "task2";},
                    () -> "task3");

            executorService.execute(runnableTask); //void
            Future<?> myRun = executorService.submit(runnableTask); //Future
            Future<String> future = executorService.submit(callableTask); //Future

            System.out.println("submit of Runnable: " + myRun.get() + " status: " + myRun.isDone());
            System.out.println("submit of Callable: " + future.get()+ " status: " + future.isDone());

            String result = executorService.invokeAny(callableTasks); //T is String
            System.out.println("invokeAny: " + result);
/*
            List<Future<String>> futures = executorService.invokeAll(callableTasks); //List of Future<String>
            System.out.println("invokeAll: " + futures.size());
            //futures.forEach(s -> System.out.println("List's element status: " + s.isDone()));
            futures.stream()
                    .map(fut -> {
                        try {
                            return fut.get();
                        }
                        catch (Exception e) {
                            throw new IllegalStateException(e);
                        }
                    })
                    .forEach(System.out::println);
                    */
        } catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }
        finally {
            if(executorService!= null){ //risk of NullPointer
                //executorService.shutdown();
                List<Runnable> notExecutedTasks = executorService.shutdownNow();
                System.out.println("Shutdown size: " + notExecutedTasks.size());
            }
        }
    }
}
