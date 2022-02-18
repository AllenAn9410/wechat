package cn.anx.serve.service.wechat;

/**
 * 微信信息服务类
 */
public interface IWechatInfoService {

    /**
     * 获取微信openId
     * @param code 登录返回编码
     * @return String
     */
    String getOpenId(String code);
}
