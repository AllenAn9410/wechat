package cn.anx.serve.controller;

import cn.anx.serve.entity.ServeResponse;
import cn.anx.serve.service.IWechatInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/openid")
    public ServeResponse<String> listUsers(String code) {
        String openId = wechatInfoService.getOpenId(code);
        return ServeResponse.success(openId);
    }
}
