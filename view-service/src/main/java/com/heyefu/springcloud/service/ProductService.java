package com.heyefu.springcloud.service;

import com.heyefu.springcloud.client.ProductFeignClient;
import com.heyefu.springcloud.client.ProductRibbonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 *
 * @author heyefu
 * Create in: 2019-12-04
 * Time: 11:21
 **/
@Service
public class ProductService {

    @Autowired
    ProductRibbonClient productClientRibbon;

    @Autowired
    ProductFeignClient feignClient;

    public List listProducts(){
        return productClientRibbon.listProdcuts();

    }

    public List listProductsFromFeign() {

        return feignClient.listProdcuts();
    }
}
