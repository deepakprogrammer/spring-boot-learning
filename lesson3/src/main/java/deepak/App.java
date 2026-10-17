package deepak;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

interface Engine{}

@Component
@Primary
class PetrolEngine implements Engine{
    PetrolEngine(){
        System.out.println("PetrolEngine created");
    }
}

@Component
class DieselEngine implements Engine{
    DieselEngine(){
        System.out.println("DieselEngine created");
    }
}

@Component
class Car{
    Car(@Qualifier("diselEngine") Engine engine){
       System.out.println("Car created with " + engine);
    }
}

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
