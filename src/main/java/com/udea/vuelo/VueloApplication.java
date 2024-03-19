package com.udea.vuelo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * This class represents the main application class for the application.
 * This class plays a crucial role in bootstrapping the application and configuring CORS settings for HTTP requests.
 *
 * @author Natalia García
 * @author Héctor Güiza
 * @author Jeisson Barrantes
 * @author Hellen Rubio
 */
@SpringBootApplication
public class VueloApplication {

	/**
	 * The main method of the application, responsible for bootstrapping the Spring Boot application.
	 * It starts the Spring application context and initializes the application with the necessary configurations.
	 *
	 * @param args Command-line arguments passed to the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(VueloApplication.class, args);
	}

	/**
	 * Creates and configures a CORS filter bean to handle Cross-Origin Resource Sharing (CORS) configuration.
	 * The CORS filter allows cross-origin requests from http://localhost:3000, and it allows credentials, headers, and methods for all endpoints.
	 *
	 * @return The configured CORS filter bean.
	 */
	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("http://localhost:3000");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}
}

