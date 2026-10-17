package deepak;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
class Engine{
    Engine(){
        System.out.println("Engine created");
    }
}

@Component
class Car{
    //private final Engine engine;
    private final ObjectProvider<Engine> engineProvider;
    Car(ObjectProvider<Engine> engineProvider){
        this.engineProvider = engineProvider;
        System.out.println("Car created");
    }

    Engine getEngine(){
        return engineProvider.getObject();
    }
}

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(App.class, args);
        System.out.println("Context ready");
        
        // Engine e1 = ctx.getBean(Engine.class);
        // System.out.println("Got: " + e1);

        // Engine e2 = ctx.getBean(Engine.class);
        // System.out.println("Got: " + e2);

        Car car1 = ctx.getBean(Car.class);
        System.out.println("Car 1 engine: "+ car1.getEngine());

        Car car2 = ctx.getBean(Car.class);
        System.out.println("Car 2 engine: " + car2.getEngine());

    }
}
