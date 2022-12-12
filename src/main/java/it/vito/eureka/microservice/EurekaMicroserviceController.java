package it.vito.eureka.microservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class EurekaMicroserviceController {
    private final AtomicInteger counter = new AtomicInteger();
    private @Value("${eureka.instance.instance-id}") String instanceId;

    @GetMapping("/process")
    public String process() {
        return String.format("Instance: %s, message counter: %d",
                instanceId, counter.incrementAndGet());
    }
}
