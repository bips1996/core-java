package Multithreading.Concepts;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

class ExplicitSharedResource {
    public void printMessage(String msg){
        ReentrantLock rl = new ReentrantLock();
        rl.lock();
        try {
            Thread.sleep(50);
        } catch(Exception e) {
            e.printStackTrace();
        }
        for(int i = 0;i<3;i++)
            System.out.println(Thread.currentThread().getName()+" running "+msg);
        rl.unlock();
    }
}

public class ExplicitLocking {
public static void main(String[] args) {
    ExplicitSharedResource esr = new ExplicitSharedResource();
    Runnable r1 = () ->{ esr.printMessage("Thread 1");};
    Runnable r2 = () -> {esr.printMessage("Thread2");};

    ExecutorService e = Executors.newFixedThreadPool(2);

    e.execute(r2);
    e.execute(r1);

    e.shutdown();

}    
}
