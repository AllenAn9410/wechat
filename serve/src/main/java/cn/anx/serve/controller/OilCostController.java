package cn.anx.serve.controller;

import cn.anx.serve.entity.ServerResponse;
import cn.anx.serve.entity.user.UserInfo;
import cn.anx.serve.entity.wechat.OilCost;
import cn.anx.serve.service.user.IUserInfoService;
import cn.anx.serve.service.wechat.IOilCostService;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author 安鑫(anx @ microvideo.cn)
 * @since 2022/03/02 11:10
 */
@Slf4j
@RestController
@RequestMapping("/oil/cost")
public class OilCostController {

    @Autowired
    IOilCostService oilCostService;

    @GetMapping("/list")
    public ServerResponse<List<OilCost>> listOilCost() {
        return ServerResponse.success(oilCostService.listOilCost());
    }

    @PostMapping
    public ServerResponse<Integer> insertOilCost(@RequestBody String oilCostStr) {
        log.info("insert oil cost : [{}]", oilCostStr);
        JSONObject jsonObject = JSONObject.parseObject(oilCostStr);
        OilCost oc = new OilCost();
        oc.setCost(jsonObject.getDouble("cost"));
        oc.setCurrentKm(jsonObject.getInteger("currentKm"));
        oc.setTotalOil(jsonObject.getInteger("totalOil"));
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime costDate = LocalDateTime.parse(jsonObject.getString("costDate"), format);
        oc.setCostDate(costDate);
        return ServerResponse.success(oilCostService.insertOilCost(oc));
    }

    @PutMapping
    public ServerResponse<Integer> updateOilCost(@RequestBody String oilCostStr) {
        log.info("insert oil cost : [{}]", oilCostStr);
        JSONObject jsonObject = JSONObject.parseObject(oilCostStr);
        OilCost oc = new OilCost();
        oc.setCost(jsonObject.getDouble("cost"));
        oc.setCurrentKm(jsonObject.getInteger("currentKm"));
        oc.setTotalOil(jsonObject.getInteger("totalOil"));
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime costDate = LocalDateTime.parse(jsonObject.getString("costDate"), format);
        oc.setCostDate(costDate);
        return ServerResponse.success(oilCostService.updateOilCost(oc));
    }

    @DeleteMapping
    public ServerResponse<Integer> deleteOilCost(Integer oilCostId) {
        return ServerResponse.success(oilCostService.delOilCost(oilCostId));
    }




}
