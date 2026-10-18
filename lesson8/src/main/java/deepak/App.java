package deepak;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ConfigurationPropertiesScan
//@EnableConfigurationProperties(MailProps.class)
public class App {
    public static void main(String[] args)throws Exception {
        //ConfigurableApplicationContext ctx = SpringApplication.run(App.class, args);
        // DataSource ds = ctx.getBean(DataSource.class);

        // System.out.println("DataSource class: " + ds.getClass().getName());

        // try(Connection c = ds.getConnection(); Statement st = c.createStatement()){
        //     System.out.println("Database URL: " + c.getMetaData().getURL());
        //     st.execute("CREATE TABLE IF NOT EXISTS visit (v INT)");
        //     st.execute("INSERT INTO visit (v) VALUES (1)");
        //     ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM visit");
        //     rs.next();
        //     System.out.println("Rows in visit table: " + rs.getInt(1));
        // }
        SpringApplication.run(App.class, args);
    }
}

@Component
class Greeter{
    private final String greeting;
    Greeter(@Value("${app.greeting:Hi from default}") String greeting){
        this.greeting = greeting;
        System.out.println("Greeter created with: " + greeting);
    }
}

@ConfigurationProperties(prefix = "app.mail")
//@Component
record MailProps(String host, int port, boolean enabled){}

@Component
class Mailer{
    Mailer(MailProps props){
        System.out.println("Env var seen by JVM: " + System.getenv("APP_MAIL_HOST"));
        System.out.println("Mailer got: " + props);
        System.out.println("port + 1 = " + (props.port() + 1));
    }
}