package deepak;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class App {
    public static void main(String[] args)throws Exception {
        ConfigurableApplicationContext ctx = SpringApplication.run(App.class, args);
        DataSource ds = ctx.getBean(DataSource.class);
        System.out.println("DataSource class: " + ds.getClass().getName());

        try(Connection c = ds.getConnection()){
            System.out.println("Database URL: " + c.getMetaData().getURL());
        }
    }
}
