package cn.anx.serve.service.wechat.impl;

import cn.anx.serve.constant.WechatConstant;
import cn.anx.serve.entity.wechat.OpenIdResponse;
import cn.anx.serve.service.wechat.IWechatInfoService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


/**
 * @author anx
 * @since 2022/02/18 09:30
 */
@Service
@Slf4j
public class WechatInfoServiceImpl implements IWechatInfoService {

    @Value("${wechat.appid}")
    private String appId;

    @Value("${wechat.secret}")
    private String appSecret;


    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String getOpenId(String code) {
        String url = WechatConstant.GET_OPEN_ID_URL
                + "?appid=" + appId
                + "&secret=" + appSecret
                + "&js_code=" + code
                + "&grant_type=authorization_code";
        log.info("get openid url : [{}]", url);
        String responseStr = null;
        try {
            responseStr = restTemplate.getForObject(url, String.class);
        } catch (RestClientException e) {
            log.error(e.toString());
        }
        log.info("response : [{}]", responseStr);
        if (StringUtils.isNotBlank(responseStr)) {
            return JSON.parseObject(responseStr, OpenIdResponse.class).getOpenid();
        } else {
            return null;
        }
    }
}
