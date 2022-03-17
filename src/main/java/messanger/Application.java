package messanger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    // Vadym: the "main" method of a Spring Boot app should be untouchable: no logic should be placed inside,
    // just the standard one line: "SpringApplication.run(Application.class, args);"
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
