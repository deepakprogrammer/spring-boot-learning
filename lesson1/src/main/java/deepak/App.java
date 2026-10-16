package deepak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;


class Engine{
    Engine(){
        System.out.println("Engine created");
    }
}
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        System.out.println("Start");
        ConfigurableApplicationContext ctx = SpringApplication.run(App.class, args);
        System.out.println("Context ready");
        Engine e1 = ctx.getBean(Engine.class);
        System.out.println("Got: " + e1);
        Engine e2 = ctx.getBean(Engine.class);
        System.out.println("Got: " + e2);
        System.out.println("End");
    }
}
