// Method reference:: Pass method signature inside another method and inner method is responsible for execution

import java.util.Arrays;
import java.util.List;

public class MethodReferenceEx {
    public static void main(String args[]) {
        List<String> li = Arrays.asList("Biplab","Ashish","Hitesh");


        //Normal Way
        List<String> caps = li.stream().map(item -> item.toUpperCase()).toList();

        for(String s :caps) System.out.println(s);

        //Method reference
        List<String> caps2  = li.stream().map(String::toUpperCase).toList();
        
        caps2.forEach(System.out::println);




    }
    
}
