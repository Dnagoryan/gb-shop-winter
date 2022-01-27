package ru.gb.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.service.CategoryService;
import ru.gb.service.ManufacturerService;
import ru.gb.service.ProductService;
import ru.gb.web.dto.CategoryDto;
import ru.gb.web.dto.ManufacturerDto;
import ru.gb.web.dto.ProductDto;
import ru.gb.web.dto.ProductManufacturerDto;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/gb-shop")
public class ShopController {

    private final ProductService productService;
    private final ManufacturerService manufacturerService;
    private final CategoryService categoryService;

    @GetMapping("/product")
    public List<ProductDto> getProducts() {
        return productService.getProductList();
    }

    @GetMapping("/product/info")
    public List<ProductManufacturerDto> getProductInfo() {
        return productService.getInfoProductList();
    }

    @GetMapping("/manufacturer")
    public List<ManufacturerDto> getManufacturers() {
        return manufacturerService.getManufacturerList();
    }

    @GetMapping("/category")
    public List<CategoryDto> getCategories() {
        return categoryService.getCategoryList();
    }


}
