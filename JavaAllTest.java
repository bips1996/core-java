import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.stream.Stream;


// //functional
// interface I1 {
//     public abstract void readme();
// }

// //normal
//  interface I2 {
//     public abstract void readme();
//     public abstract void write();

// }

// class A implements I1 {
//     @Override
//     public void readme() {
//         System.out.println("Hello I1");
        
//     }
// }

// class B implements I1,I2{
//     @Override
//     public void readme() {
//         System.out.println("Hello I2");
//     }

//     @Override
//     public void write() {
//         System.out.println("Hello I1-W");
//     }
// }

// public class JavaAllTest {
 
//     public static void main(String[] args) {

//         //function interface implementation using lambda
//         I1 a = () -> {
//             System.out.println("hey there");
//         };
        
//         //normal interface implementation
//         I2 b = new I2() {
//             public void readme() {};
//             public void write() {};
//         };

        
//     }
     
// }



class Mem {
    int ctr = 0;
    public synchronized void increment() {
        this.ctr+=1;
    }
}

public class JavaAllTest {
    public static void main(String[] args) {

        Mem m = new Mem();

        Runnable a = ()->{
            m.increment();
        };
        ExecutorService e = Executors.newFixedThreadPool(1000);

        for(int i = 0;i<1000;i++) {
            e.submit(a);
        }
        e.close();
        System.out.println(m.ctr);

    }
}
        




//         // ArrayList<Integer> al = new ArrayList<Integer>(100000);
//         // MapCollection <Integer,Integer> mp = new ConcurrentHashMap <Integer,Integer>();

//         // Random rm = new Random();

//         // for(int i =0;i<100000; i++) {
//         //     int ele = rm.nextInt(1000);
//         //     al.add(ele);
//         // }

//         // Stream<Integer> s = al.parallelStream();

//         // Consumer<Integer>c = new Consumer<Integer>() {
//         //     @Override
//         //     public void accept(Integer t) {
//         //         mp.put(t,mp.getOrDefault(t, 0)+1);
//         //     }   
//         // };
//         // s.forEach(c);

//         // System.out.println(mp.size());



//     }
    
// }
