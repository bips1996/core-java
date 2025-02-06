package Stream;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

enum Gender {
    MALE("male"),
    FEMALE("female");

    private final String value;
    Gender(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;
    private Gender gender;
    private String department;
    private List<Project> projects;

    public static List<Employee> generateEmployees(List<Project> projects) {
        List<Employee> employees = new ArrayList<>();
        Random random = new Random();

        String[] names = {
                "Alice", "Bob", "Charlie", "David", "Emma", "Frank", "Grace", "Hannah", "Ian", "Jack",
                "Kate", "Leo", "Mia", "Nathan", "Olivia", "Paul", "Quinn", "Ryan", "Sophia", "Tom"
        };

        String[] departments = {
                "Engineering", "Marketing", "Finance", "HR", "Operations", "Sales", "IT", "Customer Support"
        };

        for (int i = 0; i < 20; i++) {
            List<Project> assignedProjects = new ArrayList<>();
            int numProjects = random.nextInt(3) + 1; // Assign 1 to 3 projects
            for (int j = 0; j < numProjects; j++) {
                assignedProjects.add(projects.get(random.nextInt(projects.size())));
            }

            // Assign gender based on index (odd = Male, even = Female)
            Gender gender = (i % 2 == 0) ? Gender.valueOf("FEMALE") : Gender.valueOf("MALE");

            // Assign department randomly
            String department = departments[random.nextInt(departments.length)];

            // Generate salary between 50K - 100K and round to 2 decimal places
            double salary = new BigDecimal(random.nextDouble() * 50000 + 50000)
                    .setScale(2, RoundingMode.HALF_UP)
                    .doubleValue();

            employees.add(Employee.builder()
                    .id(i + 1)
                    .name(names[i])
                    .age(random.nextInt(20) + 25)
                    .salary(salary)
                    .gender(gender)
                    .department(department)
                    .projects(assignedProjects)
                    .build());
        }

        return employees;
    }
}
