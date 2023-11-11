package ee.mainor.classroom.mapper;

import ee.mainor.classroom.dto.ProductDto;
import ee.mainor.classroom.model.Product;

public class ProductMapper {

    public static ProductDto toDto(Product product) {
        ProductDto productDto = new ProductDto();
        if (product == null) {
            return productDto;
        }

        productDto.setName(product.getName());
        productDto.setId(product.getId());
        productDto.setDescription(product.getDescription());
        return productDto;
    }

    public static Product toEntity(ProductDto productDto, Product target) {
        if (target == null) {
          target = new Product();
        }
        if (productDto == null) {
            return target;
        }
        target.setName(productDto.getName());
        target.setDescription(productDto.getDescription());
        return target;
    }


}
