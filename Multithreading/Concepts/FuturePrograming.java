package Multithreading.Concepts;
/*
Future programing in java revolves around the Future Interface, which represents
Results on an ASYNCHRONOUS execution.
Future interface allows devs to execute tasks concurrently and retrive their result at a later point.
Major draw back - blocking once get method is called

COMPLETABLE FUTURE
To overcome limitations of Future Java* introduced Completable future which is more powerful  and flexible
tool for asynchronous programming.
Advantage -
1. Non Blocking - thenApply(), thenAccept(), thenCompose()
2. chaining
3. Provides exceptionally() for better exception handling
 */


import java.util.concurrent.*;

class FutureExample {
    ExecutorService ex;
    FutureExample() {
        this.ex = Executors.newFixedThreadPool(10);
    }

    public void example() throws InterruptedException, ExecutionException {
        Future<Integer> future = ex.submit(()->{
            System.out.println("task 1 execution started");
            Thread.sleep(10000);
            return 1;
        });

        Integer res = future.get();
        System.out.println("task 1 execution completed "+res);
    }
}

class CompletableFutureExample {
    ExecutorService ex = Executors.newFixedThreadPool(10);
    public void example() throws InterruptedException, ExecutionException {
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(()->{
            System.out.println("task 2 execution started");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "task 2 execution completed";
        });

        cf.thenApply(result-> {
            System.out.println(result);
            return "task 2 execution completed and applied";
        })
        .thenAccept(System.out::println).exceptionally(
        e -> {
            System.out.println(e.getMessage());
        ex.shutdown();
        return null;}
        );

        cf.join(); // joining main thread for execution

        System.out.println("Main thread getting assigned to other work");


    }
}

public class FuturePrograming {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        FutureExample futureExample = new FutureExample();
//        futureExample.example();

        CompletableFutureExample cf= new CompletableFutureExample();
        cf.example();
    }
}
