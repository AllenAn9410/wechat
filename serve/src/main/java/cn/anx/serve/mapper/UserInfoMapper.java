package cn.anx.serve.mapper;

import cn.anx.serve.entity.user.UserInfo;
import cn.anx.serve.entity.wechat.join.WechatUserInfoJoinServices;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户信息 Mapper 接口
 * </p>
 *
 * @author anxin
 * @since 2022-02-16
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
  /**
   * 查询扩展
   *
   * @param wrapper 动态参数
   * @return List<UserInfoJoinServices>
   * */
  List<WechatUserInfoJoinServices> selectUserInfoJoinServices(@Param("ew") Wrapper<UserInfo> wrapper);
}
