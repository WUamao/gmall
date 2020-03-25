package com.amao.gmall.vo.ums;

import lombok.Data;
import lombok.ToString;

/**
 * @author amao
 * @date 2020/3/24 20:20
 */
@ToString
@Data
public class LoginResponseVo {

    private Long memberLevelId;

    private String username;

    private String nickname;

    private String phone;

    private String accessToken; //访问令牌

}
