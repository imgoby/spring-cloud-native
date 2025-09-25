package id.my.hendisantika.productservice.controller;

import id.my.hendisantika.productservice.model.Product;
import id.my.hendisantika.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @PostMapping
    public Product add(@RequestBody Product product) {
        return productRepository.add(product);
    }

    @PutMapping
    public Product update(@RequestBody Product product) {
        return productRepository.update(product);
    }

    @GetMapping("/products/{id}")
    public Product findById(@PathVariable("id") Long id) {
        return productRepository.findById(id);
    }

    @PostMapping("/products/ids")
    public List<Product> find(@RequestBody List<Long> ids) {
        List<Product> products = productRepository.find(ids);
        log.info("Products found: {}", products);
        return products;
    }

    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable("id") Long id) {
        productRepository.delete(id);
    }
}
