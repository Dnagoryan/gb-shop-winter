package ru.gb.service.feign;


import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.gb.web.dto.ManufacturerDto;

import java.util.List;


public interface ManufacturerApi {


    public List<ManufacturerDto> getManufacturerList();

    ResponseEntity<?> getManufacturer(@PathVariable("manufacturerId") Long id);


    public ResponseEntity<?> handlePost(@Validated @RequestBody ManufacturerDto manufacturerDto);

    public ResponseEntity<?> handleUpdate(@PathVariable("manufacturerId") Long id,
                                          @Validated @RequestBody ManufacturerDto manufacturerDto);

    public void deleteById(@PathVariable("manufacturerId") Long id);

}