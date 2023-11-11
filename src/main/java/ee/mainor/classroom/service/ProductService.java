package ee.mainor.classroom.service;

import ee.mainor.classroom.dto.ProductDto;
import ee.mainor.classroom.mapper.ProductMapper;
import ee.mainor.classroom.model.Product;
import ee.mainor.classroom.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductDto> getProductsByName(String name) {
        List<Product> products = productRepository.findAllByName(name);

        return products.stream().map(product -> {
            ProductDto productDto = new ProductDto();
            productDto.setId(product.getId());
            productDto.setName(product.getName());
            productDto.setDescription(product.getDescription());
            return productDto;
        }).toList();
    }


    @Transactional
    public ProductDto createProduct(ProductDto productDto) {
        Product productModel = ProductMapper.toEntity(productDto, null);

        Product product = productRepository.save(productModel);

        return ProductMapper.toDto(product);
    }

    @Transactional
    public ProductDto updateProduct(Long id, ProductDto productDto) {
        Product initialProduct = requireProduct(id);
        Product product = ProductMapper.toEntity(productDto, initialProduct);

        return ProductMapper.toDto(productRepository.save(product));
    }
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }


    private Product requireProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Product with id: %s was not found", id)));
    }




}
