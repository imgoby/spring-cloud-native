package id.my.hendisantika.productservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.my.hendisantika.productservice.model.Product;
import id.my.hendisantika.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;
    private final ObjectMapper mapper = new ObjectMapper();

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
    public List<Product> find(@RequestBody List<Long> ids) throws JsonProcessingException {
        List<Product> products = productRepository.find(ids);
        log.info("Products found: {}", mapper.writeValueAsString(Collections.singletonMap("count", products.size())));
        return products;
    }

    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable("id") Long id) {
        productRepository.delete(id);
    }
}
