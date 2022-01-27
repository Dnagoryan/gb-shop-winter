package ru.gb.service.feign;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.gb.web.dto.ProductDto;
import ru.gb.web.dto.ProductManufacturerDto;

import java.util.List;


public interface ProductApi {


    ResponseEntity<?> getProduct(@PathVariable("productId") Long id);


    public List<ProductManufacturerDto> getInfoProductList();


    public List<ProductDto> getProductList();


    public ResponseEntity<?> handlePost(@Validated @RequestBody ProductDto productDto);


    public ResponseEntity<?> handleUpdate(@PathVariable("productId") Long id,
                                          @Validated @RequestBody ProductDto productDto);

    public void deleteById(@PathVariable("productId") Long id);


}
