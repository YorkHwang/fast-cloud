package com.york.service.order.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:订单访问控制
 * @Author: York.Hwang
 * @Date: 2020/3/7 10:08
 */
@RestController
@RequestMapping("/order")
public class OrderController {


    @Autowired
    RestTemplate restTemplate;


    @RequestMapping("/get/{orderId}")
    public String getOrder(@PathVariable Long orderId) {
        ResponseEntity<String> result = restTemplate.getForEntity("http://PRODUCT-SERVICE/product/ip", String.class);
        return orderId+", rest query order ip:"+result.getBody();
    }



}
