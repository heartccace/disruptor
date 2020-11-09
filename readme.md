## disruptor



### sequece、sequecer、sequece barries



### waitStrategy

blockingWaitStrategy: 效率最低的策略，但其对cpu的消耗最小，并且在各种不同的部署环境中能提供更加一直的性能表现

sleepingWaitStrategy：性能跟blockingWaitStrategy差不多，对CPU的消耗也差不多，但对生产者线程的影响最小，适合异步日志类似场景

yieldingWaitingStrategy：性能最好，适合低延迟的系统。再要求极高性能且事件处理线程数小于CPU逻辑核心线程数的场景中，推荐使用。例如，CPU开去超线程特性



### Disruptor核心-EventProcessor

EventProcessor:主要事件循环，处理Disruptor中的Event，并拥有消费者的Sequence

他有一个实现类BatchEventProcessor，包含了event loop有效的实现，并且将回调到一个EventHandler接口的实现对象



