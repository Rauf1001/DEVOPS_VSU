package main.java.com.rest.backend.k8s_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello(){
        String name = System.getenv("NAME");
        if (name == null){
            name = "Student";

        }
        return "<html><body><h1>Hello " + name + "</h1><body></html>";
    }

}
