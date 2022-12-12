package it.vito.eureka.microservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class EurekaMicroserviceController {
    private final AtomicInteger counter = new AtomicInteger();
    private @Value("${eureka.instance.instance-id}") String instanceId;

    @GetMapping("/process")
    public String process() {
        return String.format("Instance: %s, message counter: %d",
                instanceId, counter.incrementAndGet());
    }
}
