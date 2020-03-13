package com.amao.gmall.ums.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.amao.gmall.ums.entity.MemberLevel;
import com.amao.gmall.ums.mapper.MemberLevelMapper;
import com.amao.gmall.ums.service.MemberLevelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 会员等级表 服务实现类
 * </p>
 *
 * @author amao
 * @since 2020-03-09
 */
@Service
@Component
public class MemberLevelServiceImpl extends ServiceImpl<MemberLevelMapper, MemberLevel> implements MemberLevelService {

}
