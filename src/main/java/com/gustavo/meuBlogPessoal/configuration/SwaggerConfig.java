package com.gustavo.meuBlogPessoal.configuration;

import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

@Configuration
public class SwaggerConfig {

	@Bean
	OpenAPI springmeuBlogPessoalOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Projeto Meu Blog Pessoal")
						.description("Projeto Meu Blog Pessoal - Genaration Brasil").version("v.0.0.1")
						.license(new License().name("Generation Brasil").url("https://brazil.generation.org/"))
						.contact(new Contact().name("Gustavo Barbosa")
								.url("https://github.com/Guxtta5/Meu-Blog-Pessoal").email("guh.barbosa.k@gmail.com")))
				.externalDocs(new ExternalDocumentation().description("Github")
						.url("https://github.com/Guxtta5/Meu-Blog-Pessoal"));
	}

	private ApiResponse createApiResponse(String message) {
		return new ApiResponse().description(message);
	}

	@Bean
	OpenApiCustomizer customerGlobalHeaderOpenApiCustomiser() {
		return openApi -> {
			openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {

				ApiResponses apiResponses = operation.getResponses();

				apiResponses.addApiResponse("200", createApiResponse("Sucesso!!"));
				apiResponses.addApiResponse("201", createApiResponse("Objeto Persistido!"));
				apiResponses.addApiResponse("204", createApiResponse("Objeto Excluido!"));
				apiResponses.addApiResponse("400", createApiResponse("Erro na Requisição!"));
				apiResponses.addApiResponse("401", createApiResponse("Acesso não Autorizado!"));
				apiResponses.addApiResponse("403", createApiResponse("Acesso Proibido!"));
				apiResponses.addApiResponse("404", createApiResponse("Objeto não Encontrado!"));
				apiResponses.addApiResponse("500", createApiResponse("Erro na Aplicação!"));
			}));
		};
	}
}