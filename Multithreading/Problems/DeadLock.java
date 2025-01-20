package Multithreading.Problems;
//create a deadlock

class SharedReSource {
    int sharedCounter;

    Object lock1 = new Object();
    Object lock2 = new Object();

    SharedReSource(int sharedCounter) {
        this.sharedCounter = sharedCounter;
    }
    public synchronized void  incrementSharedCounter() {
        synchronized (lock1) {
            System.out.println("Inside incrementSharedCounter LOCK1");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized (lock2) {
            ++sharedCounter;
            System.out.println("Inside incrementSharedCounter LOCK2");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void  decrementSharedCounter() {
        synchronized (lock2) {
            --sharedCounter;
            System.out.println("Inside decrementSharedCounter LOCK2");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        synchronized (lock1) {
            System.out.println("Inside decrementSharedCounter LOCK1");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public int getSharedCounter() {
        return sharedCounter;
    }
}
public class DeadLock {
    public static void main(String[] args) {
        SharedReSource sharedReSource = new SharedReSource(0);

        Runnable r1 = () -> {
            sharedReSource.incrementSharedCounter();
            System.out.println("Inside t1, counter = "+sharedReSource.getSharedCounter());
        };

        Runnable r2 = () -> {
            sharedReSource.decrementSharedCounter();
            System.out.println("Inside t2, counter = "+sharedReSource.getSharedCounter());
        };
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
    }
}
