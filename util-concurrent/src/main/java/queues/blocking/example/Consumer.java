package queues.blocking.example;

import java.util.concurrent.BlockingQueue;

/**
 * Потребетель
 */
public class Consumer implements Runnable {
    private String consumerName;
    private final BlockingQueue<Product> queue;

    public Consumer(String consumerName, BlockingQueue<Product> q) {
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
    private void consume(Product product) {
        System.out.println(" --> " + this.consumerName + " >> Consume: " + product.getInfo());
    }
}
