package ru.zgys.demo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;

/**
 * @author U.Goryntsev 30.08.2017
 */
@Configuration
public class JacksonConfig {

	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper
				.registerModule(new JavaTimeModule())
				.configure(WRITE_DATES_AS_TIMESTAMPS, false);
		return objectMapper;
	}
}
