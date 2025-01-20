//Optinal class used to avoid  null point exceptions

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalClassEx {
    public static void main(String args[]) {
        List <String> li = Arrays.asList("Biplaba","Sardar","Ashish");

        //1st way using optional class
        Optional<String> ops = li.stream()
        .filter(s -> s.contains("x"))
        .findFirst();

        //user orElse
        System.out.println(ops.orElse("Not found"));

        //2nd way without optional class
        //findFirst by default returns a optional class so creating object of optional class can be avoided

        String s2 = li.stream().filter(s->s.contains("x")).findFirst().orElse("Not fornd");

        System.out.println(s2);



    }
}
