package cn.anx.serve.service.wechat;

import cn.anx.serve.entity.wechat.OilCost;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 油耗表 服务类
 * </p>
 *
 * @author anxin
 * @since 2022-03-02
 */
public interface IOilCostService extends IService<OilCost> {

    /**
     * 获取所有列表.
     * @return
     */
    List<OilCost> listOilCost();

    /**
     * 新增油耗.
     * @param oilCost 油耗对象
     * @return 新增数量
     */
    Integer insertOilCost(OilCost oilCost);

    /**
     * 跟新.
     * @param oc 油耗对象
     * @return 新增数量
     */
    Integer updateOilCost(OilCost oc);

    /**
     * 删除.
     * @param oilCostId
     * @return
     */
    Integer delOilCost(Integer oilCostId);
}
