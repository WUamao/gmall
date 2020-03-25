package com.amao.gmall.ums.service;

import com.amao.gmall.ums.entity.Member;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
