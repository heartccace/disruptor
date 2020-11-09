package cn.disruptor.factory;

import cn.disruptor.event.OrderEvent;
import com.lmax.disruptor.EventFactory;

/**
 * @author heartccace
 * @create 2020-11-09 21:52
 * @Description TODO
 * @Version 1.0
 */
public class OrderEventFactory implements EventFactory<OrderEvent> {
    public OrderEvent newInstance() {
        return new OrderEvent();
    }
}
