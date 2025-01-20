import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ForEachEx {
    public static void main(String args []) {
        List<Integer> l  = Arrays.asList(1,2,3,4,5,6,7,8,9);

        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer t) {
               t = t*100;
               System.out.println(t);
            }
        };

        l.forEach(consumer);

        System.out.println(l);

    }
}
