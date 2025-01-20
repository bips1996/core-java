import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Thread safe counter
// Executer Service
// Synchronized
// Lambda

class Counter {
    int c = 0;
    public  synchronized void increment() {
        c+=1;
    }
}

public class ThreadSafe {
    public static void main(String[] args)  {

    Counter cnt = new Counter();

        Runnable a = () -> {
            for(int i=0;i<10;i++) { 
                cnt.increment();
            }
        };

        Runnable b = ()-> {
            for(int i=0;i<10;i++) {
                cnt.increment();
            }
        };

      ExecutorService executor = Executors.newFixedThreadPool(10);

      for(int i=0;i<10;i++) {
            executor.submit(a);
      }
        executor.shutdown();
        System.out.println("Main thread ends here..."+ cnt.c);
    }
}
