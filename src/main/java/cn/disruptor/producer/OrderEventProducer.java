package cn.disruptor.producer;

import cn.disruptor.event.OrderEvent;
import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * @author heartccace
 * @create 2020-11-09 22:13
 * @Description TODO
 * @Version 1.0
 */
public class OrderEventProducer {

    private RingBuffer<OrderEvent> content;

    public OrderEventProducer(RingBuffer<OrderEvent> ringBuffer) {
        this.content = ringBuffer;
    }

    public void sendData(ByteBuffer data) {
        long sequence = this.content.next();
        try{
            OrderEvent orderEvent = this.content.get(sequence);
            orderEvent.setValue(data.getLong(0));
        }finally {
            this.content.publish(sequence);
        }
    }
}
