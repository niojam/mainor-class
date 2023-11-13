package ee.mainor.classroom.integration;

import ee.mainor.classroom.EnableTestContainers;
import ee.mainor.classroom.dto.ProductDto;
import ee.mainor.classroom.model.Product;
import ee.mainor.classroom.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
@EnableTestContainers
public class ProductServiceIntegrationTest {

    @Autowired
    private ProductService productService;

    @Test
    void shouldNotFindProductsByNameWhenDoesNotExist() {
        List<ProductDto> actual = productService.getProductsByName("test");

        assertThat(actual).hasSize(0);
    }


    @Test
    void shouldFindProductsByNameWhenNameMatches() {
        List<ProductDto> actual = productService.getProductsByName("Electronics");

        assertThat(actual).hasSize(1);
        assertThat(actual.get(0).getName()).isEqualTo("Electronics");
    }



}
