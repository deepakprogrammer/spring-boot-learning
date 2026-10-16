package deepak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
class Car{

    private final Engine engine;

    Car(Engine engine){
        this.engine = engine;
        System.out.println("Inside Car constructor, engine = " + engine);
    }
}

@Component
class Engine{
    Engine(){
        System.out.println("Engine created");
    }
}

//@SpringBootApplication
public class App {
    public static void main(String[] args) {
        // ConfigurableApplicationContext ctx = SpringApplication.run(App.class, args);
        // Car car = ctx.getBean(Car.class);
        // System.out.println("After startup, engine = "+ car.engine);
        Car car = new Car(new Engine());
        //System.out.println("Without Spring, engine = " + car.engine);
    }
}
