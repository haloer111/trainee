package com.gexiao.trainee.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {

//    http://localhost:8088/swagger-ui.html     原路径
//    http://localhost:8088/doc.html     原路径

    // 配置swagger2核心配置 docket
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)  // 指定api类型为swagger2
                .apiInfo(apiInfo())                 // 用于定义api文档汇总信息
                .select()
//                .apis(RequestHandlerSelectors
//                        .basePackage("com.aojing.dataengine.database.controller"))   // 指定controller包
                // 方式二
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())         // 所有controller
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("气象核心平台")        // 文档页标题
                .contact(new Contact("aojing",
                        "https://www.aojing.com",
                        "aojing@aojing.com"))        // 联系人信息
                .description("气象核心平台api文档")  // 详细信息
                .version("1.0.0")   // 文档版本号
                .termsOfServiceUrl("https://www.aojing.com") // 网站地址
                .build();
    }

}
