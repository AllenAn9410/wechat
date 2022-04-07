package cn.anx.serve.enums;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 报表日志枚举值.
 */
public enum ReportDateRequestEnum {

    TODAY(0, "今日"),
    YESTERDAY(1, "昨天"),
    LAST_WEEK(2, "上周"),
    LAST_MONTH(3, "上月"),
    ;

    private Integer code;

    private String msg;

    ReportDateRequestEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }


    public static LocalDateTime[] getDaySpanByCode(Integer code) {
        String defaultFormatter = "yyyy-MM-dd HH:mm:ss";
        return getDaySpanByCode(code, defaultFormatter);
    }

    public static LocalDateTime[] getDaySpanByCode(Integer code, String formatter){
        List<LocalDateTime> span = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        switch (code) {
            case 0:
                LocalDateTime todayStart = now.withHour(0).withMinute(0).withSecond(0).withNano(0);
                LocalDateTime todayEnd = todayStart.plusDays(1).plusSeconds(-1);
                span.add(todayStart);
                span.add(todayEnd);
                break;
            case 1:
                LocalDateTime yesterdayStart = now.plusDays(-1).withHour(0).withMinute(0).withSecond(0).withNano(0);
                LocalDateTime yesterdayEnd = yesterdayStart.plusDays(1).plusSeconds(-1);
                span.add(yesterdayStart);
                span.add(yesterdayEnd);
                break;
            case 2:
                int dayOfWeek = now.getDayOfWeek().getValue() - 1;
                LocalDateTime lastWeekStart = now.plusDays(-dayOfWeek).plusWeeks(-1).withHour(0).withMinute(0).withSecond(0).withNano(0);
                LocalDateTime lastWeekEnd = lastWeekStart.plusDays(7).plusSeconds(-1);
                span.add(lastWeekStart);
                span.add(lastWeekEnd);
                break;
            case 3:
                int dayOfMonth = now.getDayOfMonth() - 1;
                LocalDateTime lastMonthStart = now.plusDays(-dayOfMonth).plusMonths(-1).withHour(0).withMinute(0).withSecond(0).withNano(0);
                LocalDateTime lastMonthEnd = lastMonthStart.plusMonths(1).plusSeconds(-1);
                span.add(lastMonthStart);
                span.add(lastMonthEnd);
                break;
            default:
                break;
        }
        return span.toArray(new LocalDateTime[]{});
    }
}
