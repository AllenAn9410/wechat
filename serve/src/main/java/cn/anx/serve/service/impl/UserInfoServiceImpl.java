package cn.anx.serve.service.impl;

import cn.anx.serve.entity.UserInfo;
import cn.anx.serve.mapper.UserInfoMapper;
import cn.anx.serve.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author anxin
 * @since 2022-02-16
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
