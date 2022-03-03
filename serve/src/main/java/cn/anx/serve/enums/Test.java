package cn.anx.serve.enums;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @author 安鑫(anx @ microvideo.cn)
 * @since 2022/03/01 16:16
 */
public class Test {
    public static void main(String[] args) {
        LocalDateTime[] daySpanByCode = ReportDateRequestEnum.getDaySpanByCode(0);
        System.out.println(Arrays.toString(daySpanByCode));
    }
}
