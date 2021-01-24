package console;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = "console learnprogramming.config")
public class Main {


    public static void main(String[] args) {
        log.info("Guess The Number Game");

        SpringApplication.run(Main.class, args);
    }
}
