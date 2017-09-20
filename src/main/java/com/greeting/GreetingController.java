package com.greeting;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting/name/{name}")
    public Greeting greeting(@PathVariable("name") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
}
