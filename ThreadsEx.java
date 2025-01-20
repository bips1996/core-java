class A extends Thread {  
    public synchronized  void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Inside thread A");
        }
    }
}

class B extends Thread {
    public synchronized void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Inside thread B");
        }
    }
}


public class ThreadsEx {
    public static synchronized void main(String[] args) {
        System.out.println("Main thread starts here...");
        A a = new A();
        B b = new B();
        a.setPriority(1);
        b.setPriority(10);
        a.start();
        b.start();

        try {
            a.join();
            b.join();
        } catch (InterruptedException e) {          
            e.printStackTrace();
        }
 

        System.out.println("Main thread ends here..., a.getPriority() = " + a.getPriority());
    }
}