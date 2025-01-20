package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterEx {
    public static void main(String[] args) {
        List<Integer> sampleList = Arrays.asList(1,2,3,4,5,6,7,8,89,2,3,5);

        Predicate<Integer> p = (Integer a) -> a > 3;

        List<Integer> filteredList = sampleList.stream().filter(a -> a>3).collect(Collectors.toList());
        
        List<Integer> filteredList2 = sampleList.stream().filter(p).collect(Collectors.toList());

        for(Integer a:filteredList2) {
            System.out.println(a);
        }
    }
}
