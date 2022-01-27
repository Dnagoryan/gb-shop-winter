package ru.gb.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.gb.service.feign.ManufacturerApi;
import ru.gb.web.dto.ManufacturerDto;

import java.util.List;

@FeignClient(url = "localhost:8080/api/v1/manufacturer", value = "manufacturerApi")
public interface ManufacturerService extends ManufacturerApi {

    @Override
    @GetMapping(produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    List<ManufacturerDto> getManufacturerList();

    @Override
    @GetMapping(produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8", value = "/{manufacturerId}")
    ResponseEntity<?> getManufacturer(@PathVariable("manufacturerId") Long id);

    @Override
    @PostMapping(produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    ResponseEntity<?> handlePost(@Validated @RequestBody ManufacturerDto manufacturerDto);

    @Override
    @PutMapping(produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8", value = "/{manufacturerId}")
    ResponseEntity<?> handleUpdate(@PathVariable("manufacturerId") Long id, @Validated @RequestBody ManufacturerDto manufacturerDto);

    @Override
    @DeleteMapping(produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8", value = "/{manufacturerId}")
    void deleteById(@PathVariable("manufacturerId") Long id);
}
