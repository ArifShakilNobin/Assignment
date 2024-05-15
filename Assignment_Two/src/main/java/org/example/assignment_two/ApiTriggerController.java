package org.example.assignment_two;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiTriggerController {

    private final IntegrationFlow integrationFlow;

    public ApiTriggerController(IntegrationFlow integrationFlow) {
        this.integrationFlow = integrationFlow;
    }

    @PostMapping("/triggerApi")
    public ResponseEntity<String> triggerApi(@RequestBody MyRequest payload) {
        integrationFlow.getInputChannel().send(MessageBuilder.withPayload(payload).build());
        return ResponseEntity.ok("API call triggered successfully");
    }
}
