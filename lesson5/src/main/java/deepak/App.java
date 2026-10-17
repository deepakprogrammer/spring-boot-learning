package deepak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Scope("prototype")
class Engine{
    // Engine(){
    //     System.out.println("1. Constructor");
    // }

    @PostConstruct
    void init(){
        System.out.println("@PostConstruct " + this);
    }

    @PreDestroy
    void cleanup(){
        System.out.println("@PreDestroy " + this);
    }
}

// @Component
// class Car{
//     @Autowired
//     Engine engine;
//     Car(){
//         System.out.println("Constructor: engine = " + engine);
//     }
//     @PostConstruct
//     void init(){
//         System.out.println("@PostConstructor: engine = " + engine);
//     }
// }

@SpringBootApplication
public class App {
    public static void main(String[] args) {
         ConfigurableApplicationContext ctx = SpringApplication.run(App.class, args);
         ctx.getBean(Engine.class);
         ctx.getBean(Engine.class);
         System.out.println("Closing context");
         ctx.close();
         System.out.println("Context closed");
        // System.out.println("Context ready");
        // ctx.close();
        // System.out.println("Context closed");
        //SpringApplication.run(App.class, args);
    }
}
