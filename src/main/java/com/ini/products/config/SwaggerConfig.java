package com.ini.products.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration //se indica que es una clase de configuraacion
@EnableSwagger2 //habilitar esta herramienta
public class SwaggerConfig {
	@Bean //patron de diseño
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select() //que seleccionar para construir
				.apis(RequestHandlerSelectors.basePackage("com.ini.products.rest")) //solo de que paquete documentara
				.paths(PathSelectors.any()) //seleccionara de todo el paquete los metodos para documentar
				.build(); //para constuir
	}
}
