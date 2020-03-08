package com.york.service.product.web;

import com.york.service.product.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @Description:产品控制器类
 * @Author: York.Hwang
 * @Date: 2020/3/5 23:50
 */
@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

    @Value("${server.port}")
    private Integer serverPort;



    @GetMapping(value = "/get")
    @ResponseBody
    public Product getProduct(@RequestParam Long productId) {
        Product product = new Product(productId, serverPort, UUID.randomUUID().toString(), new Date());
        log.warn("product=" + product);
        return product;
    }

    @ResponseBody
    @GetMapping(value = "/fetch", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Product fetchProduct() {

        Product product = new Product();
        product.setPort(serverPort);
        product.setProductId(new Random().nextLong());
        product.setProductName(UUID.randomUUID().toString());
        product.setCreateAt(new Date());

        log.warn("product=" + product);

        return product;
    }


    @ResponseBody
    @GetMapping(value = "/ip", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Integer ip() {
        return serverPort;
    }
}
