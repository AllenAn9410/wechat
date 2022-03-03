package cn.anx.serve.service.wechat.impl;

import cn.anx.serve.entity.wechat.WechatUserInfo;
import cn.anx.serve.mapper.WechatUserInfoMapper;
import cn.anx.serve.service.wechat.IWechatUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 * 微信小程序用户信息 服务实现类
 * </p>
 *
 * @author anxin
 * @since 2022-02-18
 */
@Service
@Slf4j
public class WechatUserInfoServiceImpl extends ServiceImpl<WechatUserInfoMapper, WechatUserInfo> implements IWechatUserInfoService {

    @Autowired
    private WechatUserInfoMapper mapper;

    @Override
    public Integer initWechatUserInfo(WechatUserInfo wechatUserInfo) {
        int insert = mapper.insert(wechatUserInfo);
        return insert;
    }
}
