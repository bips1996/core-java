package Stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamPractice {
    public static void main(String[] args) {
        List<Project> projects = Project.generateProjects();
        List<Employee> employees = Employee.generateEmployees(projects);

//forEach -> print all the empoyee names
        //employees.forEach(e -> System.out.println(e.getName()));

        //filter -> filter out employees with salary more than 50K
        //employees.stream().filter(e -> e.getSalary()>50000).forEach(e-> System.out.println(e.getName()+" "+e.getSalary()));

        //for above filter use collector and get a map of id-> salary
        /*
        HashMap<Integer,Double> hm = (HashMap<Integer, Double>) employees
                .stream()
                .filter(e->e.getSalary()>50000)
                .collect(Collectors.toMap(Employee::getId, Employee::getSalary));
        System.out.println(hm);
         */

//Map -> get all the names from employee list

        /*
        List<String> EmployeeNames = employees
                .stream()
                .map(Employee::getName)
                .toList();
        System.out.println(EmployeeNames);

        //->get all distinct department names
        List<String> departments = employees
                .stream()
                .map(Employee::getDepartment)
                .distinct()
                .toList();
        System.out.println(departments);
         */

//FlatMap ->  Fetch all distinct project names
        /*
        List<String> projectNames = employees
                .stream()
                .flatMap(e->e.getProjects().stream())
                .map(Project::getName)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(projectNames);
         */

//Sort -> Sort Employees By id
        /*
        employees.sort((e1, e2) -> e2.getId() - e1.getId());
        employees.
                stream()
                .forEach(e -> System.out.println(e.getId()));
         */

        // Sort by salary then by name
        /*
        employees.sort(Comparator
                .comparing(Employee::getSalary)
                        .reversed()
                .thenComparing(Employee::getId, Comparator.nullsLast(Comparator.naturalOrder())));
         */

        // Alternative approach
        /*employees
                .stream()
                        .sorted(Collections.reverseOrder(Comparator.comparing(Employee::getSalary)))
          employees
                .forEach(e -> System.out.println(e.getName()+ " " + e.getSalary()));
         */

// Min & Max -> Find highest paid and lowest paid employees
        /*
        Optional<Employee> employee = employees.stream().max(Comparator.comparing(Employee::getSalary));
        System.out.println(employee);
         */

//Grouping by -> get the employees based on gender

        Map<Gender, List<Employee>> employeesMap = employees
                .stream()
                .collect(Collectors.groupingBy(Employee::getGender));
        System.out.println(employeesMap);

        //->get only employee names based on gender
        Map<Gender,List<String>> employeeGroup = employees
                .stream()
                .collect(Collectors
                        .groupingBy(Employee::getGender,Collectors.mapping(Employee::getName,Collectors.toList()))
                );
        System.out.println(employeeGroup);

    }
}