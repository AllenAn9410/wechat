package cn.anx.serve.service.user;

import cn.anx.serve.entity.user.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * <p>
 * 用户信息 服务类
 * </p>
 *
 * @author anxin
 * @since 2022-02-16
 */
public interface IUserInfoService extends IService<UserInfo> {
    /**
     * 获取用户列表.
     * @return List
     */
    List<UserInfo> listUsers();

    PageInfo<UserInfo> pageUsers(Integer pageSize, Integer pageNo);
}
