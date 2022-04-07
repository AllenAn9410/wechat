package cn.anx.serve.service.wechat.impl;

import cn.anx.serve.entity.wechat.OilCost;
import cn.anx.serve.mapper.OilCostMapper;
import cn.anx.serve.service.wechat.IOilCostService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 油耗表 服务实现类
 * </p>
 *
 * @author anxin
 * @since 2022-03-02
 */
@Service
public class OilCostServiceImpl extends ServiceImpl<OilCostMapper, OilCost> implements IOilCostService {

    @Autowired
    private OilCostMapper mapper;

    @Override
    public List<OilCost> listOilCost() {
        return mapper.selectList(new QueryWrapper<>());
    }

    @Override
    public Integer insertOilCost(OilCost oilCost) {
        return mapper.insert(oilCost);
    }

    @Override
    public Integer updateOilCost(OilCost oc) {
        return mapper.updateById(oc);
    }

    @Override
    public Integer delOilCost(Integer oilCostId) {
        return mapper.deleteById(oilCostId);
    }
}
