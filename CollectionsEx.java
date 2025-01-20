import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
//comparator
import java.util.List;


//comparable
//starts here
// class Student implements Comparable<Student> {
//     int age;
//     String name;
    
//     public Student(int age, String name) {
//       this.age = age;
//             this.name = name;
//         }
    
        
    
//         public int compareTo(Student that) {
//             if(this.age<that.age) return 1;
//             return -1;
//         }
//     }
    
//     public class CollectionsEx {
//         public static void main(String args[]) {
//         Student s1 = new Student(28,"Biplab");
//         Student s2 = new Student(30,"Jilu");
//         Student s3 = new Student(33, "Rilu");
//         Student s4 = new Student(34,"Munu");



//         ArrayList <Student> students = new ArrayList<Student>();
//         students.add(s4);
//         students.add(s2);
//         students.add(s1);
//         students.add(s4);

//         Collections.sort(students);
//         for(Student s:students)
//             System.out.println(s.name+s.age);

//     }
// }

//end here







public class CollectionsEx {
    //Comparator
    //starts here
    public static void main(String args[]) {
        List  <Integer> arr = Arrays.asList(1003,1204,1301,1402,1009);


        Comparator<Integer> comp = (Integer o1, Integer o2)->{
            if(o1>o2) 
                return o2;
            return o1;
        };
        
        // Comparator<Integer> comp = new Comparator<Integer>() {
        //     @Override
        //     public int compare(Integer o1, Integer o2) {
        //         if(o1%1000 > o2%1000)
        //         return o2;
        //         return o1;
        //     }
        // };
        
        Collections.sort(arr,comp);

        System.out.println(arr);
    }
    //end
}
