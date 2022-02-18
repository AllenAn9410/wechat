package cn.anx.serve.entity.wechat;

import lombok.Data;

/**
 * @author 安鑫(anx @ microvideo.cn)
 * @since 2022/02/18 11:00
 */
@Data
public class OpenIdResponse {

    private String session_key;

    private String openid;
}
