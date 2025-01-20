package Stream;

import java.util.Arrays;
import java.util.List;

public class MappingEX {
    public static void main(String[] args) {
        List<Integer> sampleList = Arrays.asList(1,2,3,4,5,6,7,8,89,2,3,5);

        List<Integer> productList = sampleList.stream().map(a -> a*2).toList();
        
        for(Integer e:productList) {
            System.out.println(e);
        }
    }
}
