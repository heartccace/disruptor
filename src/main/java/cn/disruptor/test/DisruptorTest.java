package cn.disruptor.test;

import cn.disruptor.event.OrderEvent;
import cn.disruptor.factory.OrderEventFactory;
import cn.disruptor.handler.OrderEventHandler;
import cn.disruptor.producer.OrderEventProducer;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.Executors;

/**
 * @author heartccace
 * @create 2020-11-09 21:58
 * @Description TODO
 * @Version 1.0
 */
public class DisruptorTest {
    public static void main(String[] args) {
        Disruptor<OrderEvent> disruptor = new Disruptor<OrderEvent>(
                new OrderEventFactory(),
                1024 * 1024,
                Executors.newSingleThreadExecutor(),
                ProducerType.MULTI,
                new BlockingWaitStrategy()
        );
        disruptor.handleEventsWith(new OrderEventHandler());
        disruptor.start();

        /**
         * ringbuffer 首位连接的环，维护了一个序号，指向下一个可用的对象
         */
        RingBuffer<OrderEvent> ringBuffer = disruptor.getRingBuffer();

        OrderEventProducer producer = new OrderEventProducer(ringBuffer);

        ByteBuffer bb = ByteBuffer.allocate(8);
        for (int i = 0; i < 10; i++) {
            bb.putLong(0, i);
            producer.sendData(bb);
        }
        disruptor.shutdown();
    }
}
