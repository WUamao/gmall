package com.amao.gmall.admin.ums.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.amao.gmall.to.CommonResult;
import com.amao.gmall.ums.entity.MemberLevel;
import com.amao.gmall.ums.service.MemberLevelService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin
@RestController
public class UmsMemberLevelController {


    @Reference
    MemberLevelService memberLevelService;
    /**
     * 查出所有会员等级
     * @return
     */
    @GetMapping("/memberLevel/list")
    public CommonResult memberLevelList(){
        List<MemberLevel> list = memberLevelService.list();
        return new CommonResult().success(list);
    }
}
