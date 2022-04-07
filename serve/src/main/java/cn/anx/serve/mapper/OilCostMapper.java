package cn.anx.serve.mapper;

import cn.anx.serve.entity.wechat.OilCost;
import cn.anx.serve.entity.wechat.join.OilCostJoinServices;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 油耗表 Mapper 接口
 * </p>
 *
 * @author anxin
 * @since 2022-03-02
 */
@Mapper
public interface OilCostMapper extends BaseMapper<OilCost> {
  /**
   * 查询扩展
   *
   * @param wrapper 动态参数
   * @return List<OilCostJoinServices>
   * */
  List<OilCostJoinServices> selectOilCostJoinServices(@Param("ew") Wrapper<OilCost> wrapper);
}
