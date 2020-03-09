package com.amao.gmall.pms;

import com.amao.gmall.pms.entity.Brand;
import com.amao.gmall.pms.entity.Product;
import com.amao.gmall.pms.service.BrandService;
import com.amao.gmall.pms.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallPmsApplicationTests {

    @Autowired
    ProductService productService;

    @Autowired
    BrandService brandService;

    @Test
    public void contextLoads() {
        Product product = productService.getById(1);
        System.out.println(
                product
        );
    }

    @Test
    public void contextLoads1() {
//        Brand name = new Brand().setId(52L).setName("测试品牌");
//        boolean save = brandService.save(name);
//        System.out.println(save);
        Brand brand = brandService.getById(53);
        System.out.println(brand);
    }
}
