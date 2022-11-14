package app.epiboard;

import app.epiboard.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.io.IOException;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class EpiboardApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(EpiboardApplication.class, args);
	}

}
