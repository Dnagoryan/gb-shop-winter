package ru.gb.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.gb.service.feign.ProductApi;
import ru.gb.web.dto.ProductDto;
import ru.gb.web.dto.ProductManufacturerDto;

import java.util.List;

@FeignClient(url = "localhost:8080/api/v1/product", value = "productApi")
public interface ProductService extends ProductApi {

    @Override
    @GetMapping(produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8", value = "/{productId}")
    ResponseEntity<?> getProduct(@PathVariable("productId") Long id);

    @Override
    @GetMapping(produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8", value = "/info")
    List<ProductManufacturerDto> getInfoProductList();

    @Override
    @GetMapping(produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    List<ProductDto> getProductList();

    @Override
    @PostMapping(produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    ResponseEntity<?> handlePost(@Validated @RequestBody ProductDto productDto);

    @Override
    @PutMapping(produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8", value = "/{productId}")
    ResponseEntity<?> handleUpdate(@PathVariable("productId") Long id,
                                   @Validated @RequestBody ProductDto productDto);

    @Override
    @DeleteMapping(produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8", value = "/{productId}")
    void deleteById(@PathVariable("productId") Long id);
}
