package com.amao.gmall.ums.service;

import com.amao.gmall.ums.entity.Member;
import com.amao.gmall.ums.entity.MemberReceiveAddress;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author amao
 * @since 2020-03-09
 */
public interface MemberService extends IService<Member> {

    /**
     * 用户登录验证
     * @param username
     * @param password
     * @return
     */
    Member login(String username, String password);

    /**
     * 获取用户收货地址
     * @param id
     * @return
     */
    List<MemberReceiveAddress> getMemberAddress(Long id);

    /**
     * 根据AddressId获取地址
     * @param addressId
     * @return
     */
    MemberReceiveAddress getMemberAddressByAddressId(Long addressId);
}
