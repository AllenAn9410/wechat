package cn.anx.serve.controller;

import cn.anx.serve.entity.ServerResponse;
import cn.anx.serve.entity.wechat.WechatUserInfo;
import cn.anx.serve.service.wechat.IWechatInfoService;
import cn.anx.serve.service.wechat.IWechatUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信控制层
 * @author anx
 * @since 2022/02/17 19:58
 */
@RestController
@RequestMapping("/wechat")
public class WechatController {

    @Autowired
    private IWechatInfoService wechatInfoService;

    @Autowired
    private IWechatUserInfoService wechatUserInfoService;

    @GetMapping("/openid")
    public ServerResponse<String> listUsers(String code) {
        String openId = wechatInfoService.getOpenId(code);
        return ServerResponse.success(openId);
    }

    @PostMapping("/openid")
    public ServerResponse<Integer> initWechatUserInfo(WechatUserInfo wechatUserInfo) {
        Integer integer = wechatUserInfoService.initWechatUserInfo(wechatUserInfo);
        return ServerResponse.success(integer);
    }
}
