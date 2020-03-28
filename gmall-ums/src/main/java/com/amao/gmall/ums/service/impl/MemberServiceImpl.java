package com.amao.gmall.ums.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.remoting.zookeeper.ZookeeperClient;
import com.amao.gmall.ums.entity.Member;
import com.amao.gmall.ums.entity.MemberReceiveAddress;
import com.amao.gmall.ums.mapper.MemberMapper;
import com.amao.gmall.ums.mapper.MemberReceiveAddressMapper;
import com.amao.gmall.ums.service.MemberService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author amao
 * @since 2020-03-09
 */
@Service
@Component
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

    @Autowired
    MemberMapper memberMapper;

    @Autowired
    MemberReceiveAddressMapper memberReceiveAddressMapper;

    @Autowired
    MemberReceiveAddressMapper receiveAddressMapper;

    @Override
    public Member login(String username, String password) {

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            return null;
        }
        String digest = DigestUtils.md5DigestAsHex(password.getBytes());
        Member member = memberMapper.selectOne(new QueryWrapper<Member>().eq("username", username)
                .eq("password", digest));

        return member;
    }

    @Override
    public List<MemberReceiveAddress> getMemberAddress(Long id) {
        return receiveAddressMapper.selectList(new QueryWrapper<MemberReceiveAddress>().eq("member_id",id));
    }

    @Override
    public MemberReceiveAddress getMemberAddressByAddressId(Long addressId) {
        return memberReceiveAddressMapper.selectById(addressId);
    }
}
