package com.dut.visualization.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import com.google.common.base.Predicates;
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

/**
 * @author Radium
 * @version 1.0
 * @date 2021-04-13 20:42:10
 */
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwaggerConfig {

//    @Bean("SomsHealthApi")
//    public Docket createSomsHealthApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .groupName("智慧运维系统API")
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.dicadut.soms.controller"))
//                .paths(PathSelectors.any())
//                .build();
//    }

//    @Bean("SomsOmApi")
//    public Docket createSomsOmApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .groupName("运维养护系统API")
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.dicadut.soms.controller"))
//                .paths(PathSelectors.any())
//                .build();
//    }


//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("SOMS API文档")
//                .description("更多请咨询服务开发者 http://www.dicadut.com/")
//                .contact(new Contact("大连理工大学土木建筑设计研究院", "http://www.dicadut.com/", null))
//                .version("1.0")
//                .build();
//    }
@Bean
public Docket webApiConfig(){

    return new Docket(DocumentationType.SWAGGER_2)
            .groupName("webApi")
            .apiInfo(webApiInfo())
            .select()
            .paths(Predicates.not(PathSelectors.regex("/admin/.*")))
            .paths(Predicates.not(PathSelectors.regex("/error.*")))
            .build();

}

    private ApiInfo webApiInfo(){

        return new ApiInfoBuilder()
                .title("大连湾海底隧道可视化平台API文档")
                .description("本文档描述了可视化平台微服务接口定义")
                .version("1.0")
                .contact(new Contact("Yang", "http://", "qly18996348913@163.com"))
                .build();
    }
}