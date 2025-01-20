import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class ConcurrentHashMapEx {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        HashMap<Integer,Integer> mp = new HashMap<Integer,Integer>();

        ArrayList<Integer> al = new ArrayList<>();
        Random ran = new Random();
        for(int i = 0;i<10000;i++) {
            al.add(ran.nextInt(1000));
        }

        Stream s = al.stream();
      

        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer e) {
                 mp.put(e,mp.getOrDefault(e, 0)+1);
            }
        };

        s.forEach(consumer);
       
      
        System.out.println(mp.size());
    }
    
}
