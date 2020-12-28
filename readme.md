## disruptor



### sequece、sequecer、sequece barries



### waitStrategy

blockingWaitStrategy: 效率最低的策略，但其对cpu的消耗最小，并且在各种不同的部署环境中能提供更加一直的性能表现

sleepingWaitStrategy：性能跟blockingWaitStrategy差不多，对CPU的消耗也差不多，但对生产者线程的影响最小，适合异步日志类似场景

yieldingWaitingStrategy：性能最好，适合低延迟的系统。再要求极高性能且事件处理线程数小于CPU逻辑核心线程数的场景中，推荐使用。例如，CPU开去超线程特性



### Disruptor核心-EventProcessor

EventProcessor:主要事件循环，处理Disruptor中的Event，并拥有消费者的Sequence

他有一个实现类BatchEventProcessor，包含了event loop有效的实现，并且将回调到一个EventHandler接口的实现对象

### Disruptor核心-EventHandler

EventHandler：由用户实现并且代表了Disruptor中的一个消费者接口，也就是消费者逻辑的具体实现

### Disruptor核心-WorkerProcessor

WorkerProcessor: 确保每个sequence只被一个processor消费，同一个workerpool中处理多个workerprocessor不会消费同样的sequence



### Disruptor串并行操作

使用Disruptor对象的handleEventsWith(final EventHandler<? super T>... handlers) 跟多个eventhandler实现并行操作。

使用Disruptor对象的handleEventsWith(final EventHandler<? super T>... handlers). handleEventsWith(final EventHandler<? super T>... handlers)实现串行操作



使用Disruptor对象的handleEventsWith(final EventHandler<? super T>... handlers). handleEventsWith(final EventHandler<? super T>... handlers)实现多边形操作







### 并发编程线程池线程数设置

1、通过Executors工厂类创建

2、ThreadPoolExecutor自定义线程池

3、计算机密集型与I/O密集型

- 计算机密集型 （CPU密集型）：核心线程数/最大线程数（CPU核数 + 1  /CPU核数 * 2）
- I/O密集型（读写密集型）：CPU核数/(1-0.9)

