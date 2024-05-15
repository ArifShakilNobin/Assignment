package org.api.assignment_one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class AssignmentOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssignmentOneApplication.class, args);
    }

}
