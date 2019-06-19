package com.opkcloud.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com")).paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Spring Boot中使用Swagger2构建RESTful APIs").description("myapp")
                .termsOfServiceUrl("http://blog.csdn.net/java_yes").version("1.0").build();
    }

//    @Bean
//    public Docket addDocketApi() {
//        Docket docket = new Docket(DocumentationType.SWAGGER_2);
//        ApiInfo apiInfo = new ApiInfo("Restful API", "API测试", "v1.0.0",
//                "http://www.baidu.com", "", "opkcloud", "http://www.baidu.com");
//        docket.apiInfo(apiInfo);
//        return docket;
//    }

}
