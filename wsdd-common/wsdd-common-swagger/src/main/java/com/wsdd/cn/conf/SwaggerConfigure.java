package com.wsdd.cn.conf;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import com.google.common.base.Predicate;
import org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;




@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwaggerConfigure {

    @Bean
    public Docket actuator() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Spring Boot Actuator")
                .select()
                .apis(RequestHandlerSelectorsExt.withInterface())
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("App")
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    static class RequestHandlerSelectorsExt {
        public static Predicate<RequestHandler> withInterface() {
            return new Predicate<RequestHandler>() {
                @Override
                public boolean apply(RequestHandler input) {
                    return declaringClass(input) == EndpointMvcAdapter.class;
                }
            };
        }

        private static Class<?> declaringClass(RequestHandler input) {
            return input.getHandlerMethod().getMethod().getDeclaringClass();
        }
    }

}
