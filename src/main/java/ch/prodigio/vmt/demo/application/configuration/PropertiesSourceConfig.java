package ch.prodigio.vmt.demo.application.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * @author Gloria R. Leyva Jerez
 * Custom message source configuration to notification messages
 */
@Configuration
@PropertySources({
        @PropertySource("classpath:notification-alert.properties")
})
public class PropertiesSourceConfig {
}