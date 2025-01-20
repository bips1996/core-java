import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class ParallelStreamEx {
    public static void main(String args[]) {
        List <Integer> li = new ArrayList<>(10000);
        Random ran = new Random();
        for(int i = 0;i<10000;i++) {
            li.add(ran.nextInt(100));
        }

        HashMap<Integer,Integer> mp = new HashMap<Integer,Integer>(); 
        Map <Integer,Integer> mp2 =  new ConcurrentHashMap <Integer,Integer>();

        Consumer<Integer> con = new Consumer<Integer>() {
            @Override
            public void accept(Integer t) {
                    mp.put(t,mp.getOrDefault(t,0)+1);
            }
            
        };

        Consumer<Integer> pcon = new Consumer<Integer>() {
            @Override
            public  void accept(Integer t) {
                    mp2.put(t,mp.getOrDefault(t+1,0)+1);
            }
            
        };



        Stream ps = li.parallelStream(); // do operations asynchronously
        Stream s = li.stream();

        s.forEach(con);
        ps.forEach(pcon);

        System.out.println(mp.size());
        System.out.println(mp2.size());

    }
    
}
