package Multithreading.Concepts;

//this resource to be shared

class SharedResource {
    int value;
    SharedResource(int value){
        this.value = value;
    }
}

 class ThreadRunnable implements Runnable {
    SharedResource sr;
    ThreadRunnable (SharedResource sr) {
        this.sr = sr;
    }
    
    @Override
    public void run() {
      try {
        this.sr.value += 10;
      } catch(Exception e) {
        throw e;
      }
    }
}

public class RunnableEx {
    public static void main(String[] args) {
        SharedResource sr = new SharedResource(0);
        ThreadRunnable tr= new ThreadRunnable(sr);
        Thread t = new Thread(tr);

        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println(sr.value);

    }
}
