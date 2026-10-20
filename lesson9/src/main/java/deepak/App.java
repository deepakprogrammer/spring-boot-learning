package deepak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ConfigurationPropertiesScan
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}

@ConfigurationProperties(prefix = "app.mail")
record MailProps(String host, int port, boolean enabled){}

@Component
class Mailer{
    Mailer(MailProps props){
        System.out.println("Env var seen by JVM: " + System.getenv("APP_MAIL_HOST"));
        System.out.println("Mailer got: " + props);
        System.out.println("port + 1 = " + (props.port() + 1));
    }
}
