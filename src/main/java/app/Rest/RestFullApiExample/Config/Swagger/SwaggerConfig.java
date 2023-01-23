package app.Rest.RestFullApiExample.Config.Swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(info());
    }

    public ApiInfo info(){
        ApiInfo info = new ApiInfo(
                "dvd rental API",
                "ini adalah api dengan spring boot dengan postgres sql",
                "API TOS",
                "Term of service",
                new Contact("Rahma Danil","https://github.com/rahmadanil31","rahmadanil310700@gmail.com"),
                "Apeche Lisence",
                "www.apache.com",
                Collections.emptyList()
        );

        return info;
    }

    @Bean
    public InternalResourceViewResolver defaultViewResolver() {
        return new InternalResourceViewResolver();
    }
}
