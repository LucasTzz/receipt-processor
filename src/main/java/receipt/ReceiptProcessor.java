package receipt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * entry point of the application
 */
@SpringBootApplication
public class ReceiptProcessor {
    public static void main(String[] args) {
        SpringApplication.run(ReceiptProcessor.class, args);
    }
}
