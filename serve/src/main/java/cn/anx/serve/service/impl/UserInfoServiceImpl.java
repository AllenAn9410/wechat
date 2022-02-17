package cn.anx.serve.service.impl;

import cn.anx.serve.entity.UserInfo;
import cn.anx.serve.mapper.UserInfoMapper;
import cn.anx.serve.service.IUserInfoService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author anxin
 * @since 2022-02-16
 */
@Service
@Slf4j
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> listUsers() {
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        return userInfoMapper.selectList(queryWrapper);
    }

    @Override
    public PageInfo<UserInfo> pageUsers(Integer pageSize, Integer pageNo) {
        log.info("pageSize : [{}], pageNo : [{}]",pageSize, pageNo);
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        return PageHelper.startPage(pageNo, pageSize).doSelectPageInfo(() -> {
            userInfoMapper.selectList(queryWrapper);
        });
    }
}
