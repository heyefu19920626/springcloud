package com.heyefu.springcloud.controller;

import com.heyefu.springcloud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Description:
 *
 * @author heyefu
 * Create in: 2019-12-04
 * Time: 11:23
 **/
@Controller
@RefreshScope
public class ProductController {

    @Autowired
    ProductService productService;

    @Value("${version}")
    String version;

    @RequestMapping("/productsRibbon")
    public Object products(Model m) {
        List ps = productService.listProducts();
        m.addAttribute("ps", ps);
        m.addAttribute("version", version);
        return "products";
    }

    @RequestMapping("/productsFeign")
    public Object productsFromFeign(Model model) {
        List ps = productService.listProductsFromFeign();
        model.addAttribute("ps", ps);
        model.addAttribute("version", version);
        return "products";
    }
}
