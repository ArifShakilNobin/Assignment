package org.example.assignment_two;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.dsl.IntegrationFlow;

@SpringBootApplication
public class AssignmentTwoApplication {


    public static void main(String[] args) {
        SpringApplication.run(AssignmentTwoApplication.class, args);

    }

    @Bean
    public IntegrationFlow integrationFlow(HttpOutboundGateway httpGateway) {
        return IntegrationFlow
                .from("httpInputChannel") // Input channel for receiving triggers
                .<String, String>transform(payload -> {
                    return payload;
                })
                .transform(MyResponse.class, "post")
                .channel("outputChannel")
                .get();
    }
}
