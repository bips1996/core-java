package Multithreading.Concepts;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SharedPrinter {
    public void printMessage(String msg) {
        synchronized(this){
            for(int i=0;i<3;i++){
                System.out.println(Thread.currentThread().getName()+" running "+msg);
            }
        }
    }
}

public class ImplicitLockingEx {
    public static void main(String[] args) {
        SharedPrinter sr = new SharedPrinter();
        sr.printMessage("Task 0");
        Runnable r1 = ()->{sr.printMessage("Task 1");};
        Runnable r2 = ()->{sr.printMessage("Task 2");};

        ExecutorService e = Executors.newFixedThreadPool(5);

        e.execute(r1);
        e.execute(r2);

        e.shutdown();

    }
}
