package ru.zgys.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.spi.DocumentationType.SWAGGER_2;

/**
 * @author U.Goryntsev 30.08.2017
 */
@Configuration
@EnableSwagger2
@Profile("dev")
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("ru.zgys.demo.web"))
				.paths(PathSelectors.ant("/person/**"))
				.build();
	}
}
