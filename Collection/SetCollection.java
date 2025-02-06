package Collection;
/*
UnOrdered collection that does not allow redundancy
 */

import java.util.*;

class Student {
    String name;
    int age;
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class SetCollection {
    public static void main(String[] args) {
        //Write custom comparator for treeset
        Comparator<Student> ageComparator = (a,b) -> {
            return Integer.compare(a.age,b.age);
        };

        //descending
        Comparator<Student> nameComparator = (a,b)-> a.name.compareTo(b.name);


        Set<Student> hashSet = new HashSet<>();
        Set<Student> treeSet = new TreeSet<>(nameComparator.thenComparing(ageComparator)); // Sequential
        Set<Student> linkedHashSet = new LinkedHashSet<>(); // Preserve the order of insertion


        treeSet.add(new Student("Biplab", 18));
        treeSet.add(new Student("Aani", 13));
        treeSet.add(new Student("Daniel", 15));
        treeSet.add(new Student("Jill", 25));

        for(Student student : treeSet) {
            System.out.println("Name: " + student.name + " Age: " + student.age);
        }



    }
}
