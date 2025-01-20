import java.util.Arrays;
import java.util.List;

class Student {
    String name;
    int age;
    public Student(String name) {
        this.name = name;
    }

    public void getDetails() {
        System.out.println("Name : "+this.name+" age"+this.age);
    }
}

public class ConstructorReferenceEx {
    public static void main(String args[]) {
                List<String> li = Arrays.asList("Biplab","Ashish","Hitesh");

                //create a list with constructor reference
                List<Student> slist = li.stream().map(Student::new).toList();

                slist.forEach(s -> s.getDetails());

    }
}
