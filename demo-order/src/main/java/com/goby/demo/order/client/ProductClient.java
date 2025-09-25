package com.goby.demo.order.client;

import com.goby.demo.order.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-cloud-consul-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 25/01/25
 * Time: 11.23
 * To change this template use File | Settings | File Templates.
 */
@FeignClient(name = "product-service")
public interface ProductClient {

    @PostMapping("/products/ids")
    List<Product> findByIds(List<Long> ids);

    @GetMapping("/products")
    List<Product> getById(Long id);
}
