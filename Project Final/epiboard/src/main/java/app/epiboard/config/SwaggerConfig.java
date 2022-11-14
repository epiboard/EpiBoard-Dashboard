package app.epiboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(
                        RequestHandlerSelectors.basePackage("app.epiboard.service.raiderio")
                        .or(RequestHandlerSelectors.basePackage("app.epiboard.service.country"))
                                .or(RequestHandlerSelectors.basePackage("app.epiboard.service.freedictionary"))
                                .or(RequestHandlerSelectors.basePackage("app.epiboard.service.riot")))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfoBuilder().title("Epiboard Api")
                        .description("<h3>Created by Epiboard Team : </h3>" +
                                "<b><a href=\"https://www.linkedin.com/in/alexis-guyon-1545721b7/\" target=\"_blank\">Alexis Guyon</a></b>\n" +
                                "<b><a href=\"https://www.linkedin.com/in/k%C3%A9vin-vendome-79b125229/\" target=\"_blank\">Kevin Vendome</a></b>\n" +
                                "<b><a href=\"https://www.linkedin.com/in/antoine-duquenne-34b676162/\" target=\"_blank\">Antoine Duquenne</a></b>")
                        .version("v1.0.0")
                        .build());
    }

    @Bean
    UiConfiguration uiConfig() {
        return UiConfigurationBuilder.builder()
                .deepLinking(true)
                .build();
    }
}
