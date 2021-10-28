package com.example.demo.Response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class AddResponse {
    private String message;
    private String id;
}
