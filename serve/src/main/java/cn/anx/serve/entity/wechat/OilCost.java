package cn.anx.serve.entity.wechat;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 油耗表
 * </p>
 *
 * @author anxin
 * @since 2022-03-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OilCost implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 当前公里数
     */
    private Integer currentKm;

    /**
     * 加油的升数
     */
    private Integer totalOil;

    /**
     * 花销
     */
    private Double cost;

    /**
     * 花费时间
     */
    private LocalDateTime costDate;


}
