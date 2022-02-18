package cn.microvideo.zhdd.basic.database.mapper;

import cn.microvideo.zhdd.basic.database.entity.WechatUserInfo;
import cn.microvideo.zhdd.basic.database.entity.join.WechatUserInfoJoinServices;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * <p>
 * 微信小程序用户信息 Mapper 接口
 * </p>
 *
 * @author anxin
 * @since 2022-02-18
 */
public interface WechatUserInfoMapper extends BaseMapper<WechatUserInfo> {
  /**
   * 查询扩展
   *
   * @param wrapper 动态参数
   * @return List<WechatUserInfoJoinServices>
   * */
  List<WechatUserInfoJoinServices> selectWechatUserInfoJoinServices(@Param("ew") Wrapper<WechatUserInfo> wrapper);
}
