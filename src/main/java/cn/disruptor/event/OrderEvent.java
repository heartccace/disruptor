package cn.disruptor.event;

/**
 * @author heartccace
 * @create 2020-11-09 21:49
 * @Description TODO
 * @Version 1.0
 */
public class OrderEvent {
    private Long value;

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
