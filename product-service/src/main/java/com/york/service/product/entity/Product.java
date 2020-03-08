package com.york.service.product.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @Description:产品实体
 * @Author: York.Hwang
 * @Date: 2020/3/6 00:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Product {
    private Long productId;
    private Integer port;
    private String productName;
    private Date createAt;
}
