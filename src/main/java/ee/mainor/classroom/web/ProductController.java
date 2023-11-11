package ee.mainor.classroom.web;


import ee.mainor.classroom.dto.ProductDto;
import ee.mainor.classroom.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @GetMapping
    public List<ProductDto> getProductByName(@RequestParam String name) {
        return productService.getProductsByName(name);
    }

    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return productService.createProduct(productDto);
    }

    @PutMapping("{id}")
    public ProductDto updateProduct(@RequestBody ProductDto productDto, @PathVariable Long id) {
        return productService.updateProduct(id, productDto);

    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }


}
