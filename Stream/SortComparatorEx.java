package Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class SortComparatorEx {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student(6, "Bob", "2001-01-15"));
        studentList.add(new Student(4, "Diana", "2000-12-12"));
        studentList.add(new Student(3, "Charlie", "2002-03-25"));
        studentList.add(new Student(1, "Alice", "2001-06-17"));
        studentList.add(new Student(1, "Eve", "1999-11-30"));

        Comparator<Student> cpId = Comparator.comparingInt(s1->s1.id);

        Comparator<Student> cpName = Comparator.comparing((Student s) -> s.name);
        
        Collections.sort(studentList, cpId.thenComparing(cpName));


          for(Student s:studentList) {
            System.out.println(s.id+" "+s.name);
        }

    }
}
