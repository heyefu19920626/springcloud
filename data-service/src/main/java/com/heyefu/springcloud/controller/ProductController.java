package com.heyefu.springcloud.controller;

import com.heyefu.springcloud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author heyefu
 * Create in: 2019-12-04
 * Time: 8:58
 **/
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/products")
    public Object products() {
        return productService.listProducts();
    }
}
