package ch.prodigio.vmt.demo.application.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Gloria R. Leyva Jerez
 */
@Configuration
public class OpenAPIConfig {

    public static final Contact DEFAULT_CONTACT = new Contact()
            .name("Gloria Raquel Leyva Jerez")
            .email("leyvajerezgr@gmail.com")
            .url("https://www.linkedin.com/in/gloria-raquel-leyva-jerez/");

    public static final Info DEFAULT_API_INFO = new Info()
            .title("Vehicle Miles Traveled")
            .description("Microservice that exposes a CRUD by connecting to a DB in which the data of the public dataset \"04_sample_vmt_county\" available in: https://data.world/associatedpress/vehicle-miles-traveled")
            .version("1.0")
            .contact(DEFAULT_CONTACT);

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(DEFAULT_API_INFO);
    }
}