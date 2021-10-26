package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    @Autowired
    Greeting greeting;

    AtomicLong auto=new AtomicLong();
    @GetMapping("/greeting")
    public Greeting Greetings(@RequestParam(value="name") String name){
        greeting.setId(auto.incrementAndGet());
        greeting.setContent("Hii i am going to be succesfull,love yourself "+name);
        return greeting;
    }
}
