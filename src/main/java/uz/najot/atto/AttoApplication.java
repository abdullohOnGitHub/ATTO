package uz.najot.atto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AttoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AttoApplication.class, args);
    }

}
