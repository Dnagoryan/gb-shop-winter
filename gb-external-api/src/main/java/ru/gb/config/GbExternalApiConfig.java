package ru.gb.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import ru.gb.service.CategoryService;
import ru.gb.service.ManufacturerService;
import ru.gb.service.ProductService;

@Configuration
@EnableFeignClients(basePackageClasses = {ManufacturerService.class, ProductService.class, CategoryService.class})
public class GbExternalApiConfig {

}
