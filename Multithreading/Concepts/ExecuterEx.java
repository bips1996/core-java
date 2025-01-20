package Multithreading.Concepts;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecuterEx {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // Running a runnable thread class
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

        Runnable r = ()->{
            System.out.println("Inside runnable class r");
        };

        fixedThreadPool.execute(r);

        //Running a callable task
        /*A Callable is a functional interface in Java, part of the java.util.concurrent 
        package. It represents a task that can be executed by a thread or an executor, 
        similar to Runnable. However, unlike Runnable, a Callable task:
            1. Returns a result: It can return a value after completion.
            2. Throws exceptions: It allows checked exceptions to be thrown during execution.
        */

       // Define a Callable task
        Callable<String> ct = () -> {
            return "This is a callable task";
        };

        // Submit the Callable task and retrieve the result using Future
        Future<String> result = fixedThreadPool.submit(ct);

        // Get the result from the Callable task
        System.out.println("result = " + result.get());

        fixedThreadPool.shutdown();

        // 2. Using a Cached Thread Pool
        // Cached thread pool dynamically creates threads as needed and reuses idle threads.
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        // Submit multiple tasks to the cached thread pool
        for (int i = 0; i < 5; i++) {
            cachedThreadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " is executing a cached pool task.");
            });
        }

        cachedThreadPool.shutdown();

        //3. Scheduled Threadpool
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);

        Runnable periodicTask = ()-> {
            System.out.println(Thread.currentThread().getName()+ " is executing a periodic task.");
        };

        scheduler.scheduleAtFixedRate(periodicTask, 1, 2, TimeUnit.SECONDS);
        scheduler.shutdown();
        


    }
}
