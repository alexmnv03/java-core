package queues.blocking.example;

import java.util.concurrent.BlockingQueue;

/**
 * Производитель
 */
public class Producer implements Runnable {
    private static int serial = 1;

    private final String producerName;
    private final BlockingQueue<Product> queue;
    private final int delay; // Seconds

    public Producer(String producerName, int delay, BlockingQueue<Product> q) {
        this.producerName = producerName;
        this.delay = delay;
        this.queue = q;
    }
    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(this.delay * 1000); // 'delay' second.
                this.queue.put(this.produce());
            }
        } catch (InterruptedException ex) {
        }
    }
    private Product produce() {
        System.out.println("#" + this.producerName + " >> Create a new product!");
        return new Product("IPhone", serial++);
    }
}
