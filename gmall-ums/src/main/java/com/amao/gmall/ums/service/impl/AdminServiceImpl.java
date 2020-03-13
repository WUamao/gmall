package com.amao.gmall.ums.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.amao.gmall.ums.entity.Admin;
import com.amao.gmall.ums.mapper.AdminMapper;
import com.amao.gmall.ums.service.AdminService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author amao
 * @since 2020-03-09
 */
@Slf4j
@Component
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin login(String username, String password) {

        password = DigestUtils.md5DigestAsHex(password.getBytes());

        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username).eq("password",password);
        Admin admin = adminMapper.selectOne(queryWrapper);

        return admin;
    }

    /**
     * 获取用户详情
     * @param userName
     * @return
     */
    @Override
    public Admin getUserInfo(String userName) {
        Admin admin = adminMapper.selectOne(new QueryWrapper<Admin>().eq("username", userName));
        log.info(admin.toString());
        return admin;
    }

}
