package com.heyefu.springcloud.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Description:
 *
 * @author heyefu
 * Create in: 2019-12-04
 * Time: 11:17
 **/
@Service
public class ProductRibbonClient {

    @Autowired
    RestTemplate restTemplate;

    public List listProdcuts() {
        return restTemplate.getForObject("http://PRODUCT-DATA-SERVICE/products", List.class);
    }

}
