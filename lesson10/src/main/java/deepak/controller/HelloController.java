package deepak.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    String hello(){
        System.out.println("hello() called on thread: " + Thread.currentThread().getName());
        return "Hello Deepak";
    }
}
