package ProjectSpringIO;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Methods methods() {
        return new Methods();
    }
}