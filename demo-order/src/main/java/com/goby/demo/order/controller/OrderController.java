package com.goby.demo.order.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.goby.demo.order.client.ProductClient;
import com.goby.demo.order.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-cloud-consul-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 25/01/25
 * Time: 11.24
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final ProductClient productClient;

    @GetMapping("/orders/test")
    public List<Product> test() throws JsonProcessingException {
        int price = 0;
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        List<Product> products = productClient.findByIds(ids);
        return products;
    }

}
