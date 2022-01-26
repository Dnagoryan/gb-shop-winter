package ru.gb.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.gb.web.dto.ProductDto;
import ru.gb.web.dto.ProductManufacturerDto;

import java.util.List;

@FeignClient(url = "localhost:8457/product", value = "ProductApi")
public interface ProductApi {

    @PostMapping(produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    @GetMapping("/{productId}")
    ResponseEntity<?> getCartList(@PathVariable("productId") Long id);

    @PostMapping(produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    @GetMapping("/info")
    public List<ProductManufacturerDto> getInfoProductList();

    @PostMapping(produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    @GetMapping
    public List<ProductDto> getProductList();

    @PostMapping(produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    @GetMapping
    public  ResponseEntity<?> handlePost(@Validated @RequestBody ProductDto productDto);


    @PostMapping(produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    @PutMapping("/{productId}")
    public  ResponseEntity<?> handleUpdate(@PathVariable("productId") Long id,
                                           @Validated @RequestBody ProductDto productDto);

    @PostMapping(produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    @DeleteMapping("/{productId}")
    public void deleteById(@PathVariable("productId") Long id);


}
