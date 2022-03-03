package com.chat.features;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import  org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Slf4j
@SpringBootApplication(scanBasePackages={"com.chat.features"}, exclude = {DataSourceAutoConfiguration.class})
@EnableSwagger2
@ConfigurationPropertiesScan("com.chat.features")
public class RogersClientCrudOperationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RogersClientCrudOperationApplication.class, args);
	}
/*
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.basePackage("com.RogersClientCrudOperation"))
				.build();
	}*/
}

