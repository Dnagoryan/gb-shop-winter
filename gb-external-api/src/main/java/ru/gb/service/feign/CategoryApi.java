package ru.gb.service.feign;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.gb.web.dto.CategoryDto;

import java.util.List;


public interface CategoryApi {

    public List<CategoryDto> getCategoryList();

    ResponseEntity<?> getCategory(@PathVariable("categoryId") Long id);


    public ResponseEntity<?> handlePost(@Validated @RequestBody CategoryDto categoryDto);

    public ResponseEntity<?> handleUpdate(@PathVariable("categoryId") Long id,
                                          @Validated @RequestBody CategoryDto categoryDto);

    public void deleteById(@PathVariable("categoryId") Long id);

}

