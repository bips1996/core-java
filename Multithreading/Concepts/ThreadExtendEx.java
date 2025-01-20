package Multithreading.Concepts;

class ThreadA extends Thread {
    public void run(int i){
        i++;
    }    
}

public class ThreadExtendEx {
    public static void main(String[] args) {
        System.out.println("Initial state");
        ThreadA a = new ThreadA();
        a.start(); // start calls run() internally;
        System.out.println("Thread execution completed");
    }
}
