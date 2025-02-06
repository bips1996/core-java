package Stream;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    private  String code;
    private String name;
    private String client;
    public static List<Project> generateProjects() {
        return Arrays.asList(
                Project.builder().code("P001").name("E-commerce App").client("Amazon").build(),
                Project.builder().code("P002").name("Banking System").client("JP Morgan").build(),
                Project.builder().code("P003").name("Healthcare Portal").client("Pfizer").build(),
                Project.builder().code("P004").name("Social Media App").client("Facebook").build(),
                Project.builder().code("P005").name("CRM System").client("Salesforce").build(),
                Project.builder().code("P006").name("AI Chatbot").client("OpenAI").build(),
                Project.builder().code("P007").name("Cloud Storage").client("Google").build(),
                Project.builder().code("P008").name("ERP System").client("SAP").build(),
                Project.builder().code("P009").name("Video Streaming").client("Netflix").build(),
                Project.builder().code("P010").name("Cybersecurity Platform").client("McAfee").build()
        );

    }
}
