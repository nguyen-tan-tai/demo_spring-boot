package com.example.demo.configs;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.headers.Header;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
        return new OpenAPI()
                .components(new Components().addSecuritySchemes("basicScheme", new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic"))
                        .addParameters("myHeader1", new Parameter().in("header").schema(new StringSchema()).name("myHeader1"))
                        .addHeaders("myHeader2", new Header().description("myHeader2 header").schema(new StringSchema())))
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("Petstore API")
                        .version(appVersion)
                        .description(
                                "This is a sample server Petstore server. You can find out more about Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/). For this sample, you can use the api key `special-key` to test the authorization filters.")
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }

    // @Bean
    // OpenApiCustomizer openApiCustomizer() {
    // @SuppressWarnings("unchecked")
    // Schema<ErrorResponse> errorSchema = ModelConverters.getInstance().read(ErrorResponse.class).get(ErrorResponse.class.getSimpleName());
    // return openApi -> {
    // openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {
    // ApiResponses apiResponses = operation.getResponses();
    // ApiResponse error400 = new ApiResponse().description("Bad request")
    // .content(new Content().addMediaType(org.springframework.http.MediaType.APPLICATION_JSON_VALUE, new MediaType()));
    // error400.getContent().forEach((code, mediaType) -> mediaType.setSchema(errorSchema));
    // apiResponses.addApiResponse("400", error400);
    // }));
    // };
    // }
}
