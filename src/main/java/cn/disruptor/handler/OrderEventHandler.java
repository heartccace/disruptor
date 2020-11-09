package cn.disruptor.handler;

import cn.disruptor.event.OrderEvent;
import com.lmax.disruptor.EventHandler;

/**
 * @author heartccace
 * @create 2020-11-09 21:54
 * @Description TODO
 * @Version 1.0
 */
public class OrderEventHandler implements EventHandler<OrderEvent> {

    public void onEvent(OrderEvent event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("消费者：" +event.getValue());
    }
}
