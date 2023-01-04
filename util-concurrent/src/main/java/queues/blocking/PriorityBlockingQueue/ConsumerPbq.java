package queues.blocking.PriorityBlockingQueue;

import java.util.concurrent.BlockingQueue;

public class ConsumerPbq implements Runnable {
    private String consumerName;
    private final BlockingQueue<ProductPbq> queue;

    public ConsumerPbq(String consumerName, BlockingQueue<ProductPbq> q) {
        this.consumerName = consumerName;
        this.queue = q;
    }
    @Override
    public void run() {
        try {
            while (true) {
                this.consume(queue.take());
            }
        } catch (InterruptedException ex) {
        }
    }
    // Need 1 seconds to consume a product.
    private void consume(ProductPbq x) throws InterruptedException {
        System.out.println(" --> " + this.consumerName + " >> Consuming: " + x);
        Thread.sleep(1 * 1000); // 1 seconds.
    }
}
