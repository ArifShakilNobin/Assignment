package org.example.assignment_two;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HttpOutboundGateway {

    @ServiceActivator
    public MyResponse post(String payload, @Header("http_method") String method) throws Exception {
        String url = "https://sb-open.revenuemonster.my/v3/wallet/topup";
        MyRequest request = new MyRequest();

        RestTemplate restTemplate = new RestTemplate();
        MyResponse response = restTemplate.postForObject(url, request, MyResponse.class);

        return response;
    }
}
