package cn.anx.serve.service.wechat;

import cn.anx.serve.entity.wechat.WechatUserInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 微信小程序用户信息 服务类
 * </p>
 *
 * @author anxin
 * @since 2022-02-18
 */
public interface IWechatUserInfoService extends IService<WechatUserInfo> {

    Integer initWechatUserInfo(WechatUserInfo wechatUserInfo);

}
