package dk.amir.customerService.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for Swagger/OpenAPI documentation.
 * <p>
 * This class sets up the OpenAPI specification for the Customer Service API using
 * the Springdoc-openapi library. It defines metadata such as API title, version,
 * description, and contact information.
 * </p>
 *
 * @author Amirhossein
 */

@Configuration
public class SwaggerConfig {

    /**
     * Creates and configures the OpenAPI documentation bean for the application.
     *
     * @return a customized {@link OpenAPI} instance containing API metadata.
     */

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Customer Service API")
                        .version("1.0")
                        .description("Customer Service API Documentation - SPRING BOOT")
                        .contact(new Contact()
                                .name("Amirhossein")
                                .email("amirholyanasabnrab@gmail.com")
                        )
                );
    }
}
