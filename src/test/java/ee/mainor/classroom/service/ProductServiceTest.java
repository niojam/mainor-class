package ee.mainor.classroom.service;

import ee.mainor.classroom.dto.ProductDto;
import ee.mainor.classroom.model.Product;
import ee.mainor.classroom.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void shouldFindProductsByName() {
        Product product = new Product();
        product.setName("test");
        product.setId(1L);
        product.setDescription("Description");

        when(productRepository.findAllByName("test"))
                .thenReturn(List.of(product));


        List<ProductDto> actual = productService.getProductsByName("test");

        assertThat(actual).hasSize(1);

        assertThat(actual.get(0).getId()).isEqualTo(1L);
        assertThat(actual.get(0).getDescription()).isEqualTo("Description");
    }

    @Test
    void createProduct() {
    }

    @Test
    void updateProduct() {
    }

    @Test
    void deleteProduct() {
    }
}