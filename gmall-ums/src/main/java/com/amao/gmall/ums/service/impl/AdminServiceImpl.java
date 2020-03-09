package com.amao.gmall.ums.service.impl;

import com.amao.gmall.ums.entity.Admin;
import com.amao.gmall.ums.mapper.AdminMapper;
import com.amao.gmall.ums.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author amao
 * @since 2020-03-09
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

}
