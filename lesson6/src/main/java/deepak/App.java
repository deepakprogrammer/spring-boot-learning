package deepak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


class Engine{
    Engine(){
        System.out.println("Engine constructor");
    }
}

class Car{
    final Engine engine;
    Car(Engine engine){
        this.engine = engine;
    }
}

@Configuration(proxyBeanMethods = false)
class AppConfig{
    @Bean
    Engine engine(){
        System.out.println("@Bean method engine() called");
        return new Engine();
    }
    
    @Bean
    Car car1(Engine engine){
        return new Car(engine);
    }

    @Bean
    Car car2(Engine engine){
        return new Car(engine);
    }

}
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(App.class, args);
        System.out.println("Context ready");
        // System.out.println("Car: " + ctx.getBean(Engine.class));
        // System.out.println("Got: " + ctx.getBean(Engine.class));
        System.out.println("car1 engine: " + ctx.getBean("car1", Car.class).engine);
        System.out.println("car2 engine: " + ctx.getBean("car2", Car.class).engine);
        System.out.println("Config class " + ctx.getBean(AppConfig.class).getClass().getName());
    }
}
