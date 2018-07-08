package cn.wilmar.wcmdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.client.RestTemplate;

@EnableJms
@EnableWebSecurity
@EnableJpaAuditing
@SpringBootApplication
public class WcmDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WcmDemoApplication.class, args);
	}

	@Autowired
	RestTemplateBuilder builder;

	@Bean
	public RestTemplate template() {
		return builder.build();
	}
}
