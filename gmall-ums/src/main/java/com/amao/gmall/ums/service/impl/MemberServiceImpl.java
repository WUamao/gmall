package com.amao.gmall.ums.service.impl;

import com.amao.gmall.ums.entity.Member;
import com.amao.gmall.ums.mapper.MemberMapper;
import com.amao.gmall.ums.service.MemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author amao
 * @since 2020-03-09
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

}
