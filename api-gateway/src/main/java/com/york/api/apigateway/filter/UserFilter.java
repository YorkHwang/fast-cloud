package com.york.api.apigateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.RequestPath;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Description:：用户过滤器
 * @Author: York.Hwang
 * @Time: 2020/3/8 17:20
 */
@Component
@Slf4j
public class UserFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        RequestPath path = exchange.getRequest().getPath();
        log.warn(path.value());
        String un = exchange.getRequest().getQueryParams().getFirst("un");
        if (un == null) {
            log.error("没有用户名，不允许访问");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        log.warn("un={}", un);
        return chain.filter(exchange);
    }


    @Override
    public int getOrder() {
        return 0;
    }

}
