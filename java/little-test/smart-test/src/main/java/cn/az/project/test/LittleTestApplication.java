package cn.az.project.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * The type Smart test application.
 *
 * @author Liz
 */
@EnableAsync
@EnableScheduling
@SpringBootApplication
@EnableTransactionManagement
public class LittleTestApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(LittleTestApplication.class, args);
    }
}
