package mz.Hotel.JobHunter.JobHunter.DocumentationSwagger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("API for Manage JobHunters")
                .version("1.0.0")
                .description("Documentação da API de gerenciamento de pessoas a procura de emprego.")
                .contact(new Contact()
                    .name("Robson Soares")
                    .url("https://eurekamoza.blogspot.com/?m=1")
                    .email("robsonnnsoares@gmail.com")));
    }
}
