package ru.gb.web.rest.ProductControllerTest;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.gb.api.category.dto.CategoryDto;
import ru.gb.api.manufacturer.dto.ManufacturerDto;
import ru.gb.api.product.dto.ProductDto;
import ru.gb.dao.CategoryDao;
import ru.gb.dao.ManufacturerDao;
import ru.gb.dao.ProductDao;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductControllerSpringBootTest {

    final private static String CATEGORY_NAME = "Fruit";
    final private static String FAIL_CATEGORY_NAME = "Vegetables ";
    final private static String MANUFACTURER_NAME = "Global Village";

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private ManufacturerDao manufacturerDao;

    @Autowired
    private ProductDao productDao;

    @Test
    @Order(1)
    public void handlePostCategoryTest() throws Exception {
        mockMvc.perform(post("/api/v1/category")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper
                        .writeValueAsString(CategoryDto.builder()
                                .title(CATEGORY_NAME)
                                .build()
                        )
                ))
                .andExpect(status().isCreated());

        assertEquals(1, categoryDao.count());
    }

    @Test
    @Order(2)
    public void handlePostManufacturerTest() throws Exception {


        mockMvc.perform(post("/api/v1/manufacturer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper
                        .writeValueAsString(ManufacturerDto.builder()
                                .name(MANUFACTURER_NAME)
                                .build()
                        )
                ))
                .andExpect(status().isCreated());
    }


    @Test
    @Order(3)
    public void handlePostProductTest() throws Exception {
        mockMvc.perform(post("/api/v1/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper
                        .writeValueAsString(ProductDto.builder()
                                .title("Apple")
                                .category(CATEGORY_NAME)
                                .cost(BigDecimal.valueOf(100))
                                .manufacturer(MANUFACTURER_NAME)
                                .manufactureDate(LocalDate.now())
                                .build()
                        )
                ))
                .andExpect(status().isCreated());
    }

    @Test
    @Order(4)
    public void handlePostFailProductTest() throws Exception {
        mockMvc.perform(post("/api/v1/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper
                        .writeValueAsString(ProductDto.builder()
                                .title("Potato")
                                .category(FAIL_CATEGORY_NAME)
                                .cost(BigDecimal.valueOf(100))
                                .manufacturer(MANUFACTURER_NAME)
                                .manufactureDate(LocalDate.now())
                                .build()
                        )
                ))
                .andExpect(status().isConflict());
    }

    @Test
    @Order(5)
    public void getProductListTest() throws Exception {
        mockMvc.perform(get("/api/v1/product"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$.[0].id").value("1"))
                .andExpect(jsonPath("$.[0].title").value("Apple"));

    }
}
