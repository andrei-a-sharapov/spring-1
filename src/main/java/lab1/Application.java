package lab1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableAutoConfiguration(exclude = HibernateJpaAutoConfiguration.class)
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @EventListener(ApplicationReadyEvent.class)
  private void afterStartup() {
    LegacyApp.main(new String[]{});
  }
}