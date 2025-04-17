package br.senai.sp.menu.restaurante.config.swagger;

import org.springdoc.core.properties.SwaggerUiConfigParameters;
import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springdoc.core.properties.SwaggerUiOAuthProperties;
import org.springdoc.core.providers.ObjectMapperProvider;
import org.springdoc.webmvc.ui.SwaggerIndexTransformer;
import org.springdoc.webmvc.ui.SwaggerWelcomeCommon;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springdoc.core.properties.SwaggerUiConfigParameters;

@Configuration
public class OpenApiConfig {



    @Bean
    public SwaggerIndexTransformer swaggerIndexTransformer(
            SwaggerUiConfigProperties swaggerUiConfig,
            SwaggerUiOAuthProperties swaggerUiOAuth,
            SwaggerUiConfigParameters swaggerUiConfigParameters,
            SwaggerWelcomeCommon swaggerCommon,
            ObjectMapperProvider objectMapperProvider
    ) {
        return new SwaggerStaticFilesInterceptor(
                swaggerUiConfig,
                swaggerUiOAuth,
                swaggerUiConfigParameters,
                swaggerCommon,
                objectMapperProvider
        );
    }

}
