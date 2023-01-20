package app.Rest.RestFullApiExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RestFullApiExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestFullApiExampleApplication.class, args);
	}

}
