package com.example.demo.Controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Greeting {
    private long id;
    private String content;

}
