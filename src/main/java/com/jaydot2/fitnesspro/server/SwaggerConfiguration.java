package com.jaydot2.fitnesspro.server;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collection;
import java.util.Collections;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {


    private Predicate<String> selector;

    public Docket api() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(regex("/*"))
                .build()
                .apiInfo(apiInfo());
        return docket;
    }

    private ApiInfo apiInfo() {

        Contact contact = new Contact("admin", "http://jaydot2.com", null);
        Collection<VendorExtension> vendorExtensions = Collections.EMPTY_LIST;
        ApiInfo apiInfo = new ApiInfo("title", "description", "version", "termsOfServiceUrl", contact, "license", "licenseUrl", vendorExtensions);
        return apiInfo;
    }
}
