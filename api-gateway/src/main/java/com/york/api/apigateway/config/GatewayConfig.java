package com.york.api.apigateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

/**
 * @Description:网关路由配置
 * @Author: York.Hwang
 * @Date: 2020/3/7 11:36
 */
@Configuration
@Slf4j
public class GatewayConfig {


   @Bean
    public RouteLocator bdRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("translate",
                r -> r.path("/translate")
                        .uri("https://fanyi.baidu.com/translate")).build();

        log.warn("inited translate page!!!" + routes.toString());
        return routes.build();
    }



    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {

        return builder.routes().route("product-service-predicates",
                r -> r.path("/product/**")
                        .uri("lb://product-service")
        ).route("order-service-predicates",
                r -> r.path("/order/**")
                        .uri("lb://order-service")
        ).build();

    }



}
