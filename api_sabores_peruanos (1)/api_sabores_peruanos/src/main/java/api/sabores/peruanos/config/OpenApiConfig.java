package api.sabores.peruanos.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI defApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Backend ")
                        .description("Metodos de backend ")
                        .version("v1.0")
                        .contact(new Contact()
                                .name("sgd")
                                .url("https://jean.com.pe")
                                .email("sistemas@jean.com.pe"))
                        .termsOfService("TOC")
                        .license(new License().name("License").url("#"))
                );
    }
}
