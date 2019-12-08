package com.heyefu.springcloud.client;

import com.heyefu.springcloud.pojo.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * <p>
 * 实现Feign客户端的断路器.
 *
 * @author heyefu
 * Create in: 2019-12-08
 * Time: 19:41
 **/
@Component
public class ProductFeignClientHystrix implements ProductFeignClient{

    @Override
    public List listProdcuts() {
        List<Product> result = new ArrayList<>();
        result.add(new Product(0,"产品数据微服务不可用",0));
        return result;
    }
}
