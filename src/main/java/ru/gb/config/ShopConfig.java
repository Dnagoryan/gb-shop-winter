package ru.gb.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import ru.gb.service.feign.CategoryApi;
import ru.gb.service.feign.ManufacturerApi;
import ru.gb.service.feign.ProductApi;

import java.util.Optional;

@Configuration
@EnableFeignClients(basePackageClasses = {ManufacturerApi.class, ProductApi.class, CategoryApi.class})
@EnableJpaAuditing(auditorAwareRef = "auditorAwareBean")
public class ShopConfig {

    @Bean
    public AuditorAware<String> auditorAwareBean() {
        return () -> Optional.of("User");
    }
}
