package cn.az.wx.common.enums;

/**
 * @author az
 * @since 2020-06-11 23:38
 */
public enum ScheduleStatus {

    /**
     * 正常
     */
    NORMAL("0"),
    /**
     * 暂停
     */
    PAUSE("1");

    private final String value;

    ScheduleStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
