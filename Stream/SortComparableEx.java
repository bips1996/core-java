package Stream;

import java.util.ArrayList;
import java.util.Collections;

class Student implements Comparable<Student>{
    String name;
    Integer id;
    String dob;

    Student( Integer id,String name, String dob) {
        this.name = name;
        this.id = id;
        this.dob = dob;
    }

    public int compareTo(Student s) {
        if(s.id< this.id)
            return 1;
        return -1;
    }
}

public class SortComparableEx {
    public static void main(String[] args) {

        ArrayList<Student> studentList = new ArrayList<Student>();

        studentList.add(new Student(6, "Alice", "2001-01-15"));
        studentList.add(new Student(4, "Bob", "2000-12-12"));
        studentList.add(new Student(3, "Charlie", "2002-03-25"));
        studentList.add(new Student(1, "Diana", "2001-06-17"));
        studentList.add(new Student(2, "Eve", "1999-11-30"));

        Collections.sort(studentList);

        for(Student s:studentList) {
            System.out.println(s.id+" "+s.name);
        }
    }   
}
