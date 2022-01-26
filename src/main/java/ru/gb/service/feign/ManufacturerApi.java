package ru.gb.service.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(url = "localhost:8457/manufacturer", value = "ManufacturerApi")
public interface ManufacturerApi {


    @PostMapping(produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    @GetMapping("/{manufacturerId}")
    ResponseEntity<?> getCartList(@PathVariable("manufacturerId") Long id);
}
