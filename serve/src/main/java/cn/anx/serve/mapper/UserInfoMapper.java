package cn.anx.serve.mapper;

import cn.anx.serve.entity.UserInfo;
import cn.anx.serve.entity.join.UserInfoJoinServices;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
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
public interface UserInfoMapper extends BaseMapper<UserInfo> {
  /**
   * 查询扩展
   *
   * @param wrapper 动态参数
   * @return List<UserInfoJoinServices>
   * */
  List<UserInfoJoinServices> selectUserInfoJoinServices(@Param("ew") Wrapper<UserInfo> wrapper);
}
