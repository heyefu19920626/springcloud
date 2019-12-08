package com.heyefu.springcloud.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Description:
 *
 * @author heyefu
 * Create in: 2019-12-05
 * Time: 22:29
 **/
@FeignClient(value = "PRODUCT-DATA-SERVICE", fallback = ProductFeignClientHystrix.class)
public interface ProductFeignClient {

    @GetMapping("/products")
    public List listProdcuts();
}
