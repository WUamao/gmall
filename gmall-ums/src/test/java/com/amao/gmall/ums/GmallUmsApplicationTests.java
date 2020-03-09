package com.amao.gmall.ums;

import com.amao.gmall.ums.entity.Admin;
import com.amao.gmall.ums.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallUmsApplicationTests {

    @Autowired
    AdminService adminService;

    @Test
    public void contextLoads() {

//        Admin admin = new Admin().setUsername("阿毛").setPassword("12345").setNote("测试");
//        boolean b = adminService.save(admin);
//        System.out.println(b);
//        System.out.println(admin.getId());
        Admin admin = adminService.getById(4);
        System.out.println(admin);

    }

}
