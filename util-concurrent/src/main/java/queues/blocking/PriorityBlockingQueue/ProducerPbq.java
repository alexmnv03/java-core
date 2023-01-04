package queues.blocking.PriorityBlockingQueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class ProducerPbq implements Runnable {

    private final String producerName;
    private final BlockingQueue<ProductPbq> queue;
    private final int delay; // Seconds

    public ProducerPbq(String producerName, int delay, BlockingQueue<ProductPbq> q) {
        this.producerName = producerName;
        this.delay = delay;
        this.queue = q;
    }
    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(this.delay * 1000); // 'delay' seconds.
                ProductPbq newProduct = this.produce();
                System.out.println("\n#" + this.producerName + " >> New Product: " + newProduct);
                this.queue.put(newProduct);
                // Printed results may not be sorted (***):
                System.out.println("  Current products in queue: " + this.queue + " (***)");
            }
        } catch (InterruptedException ex) {
        }
    }
    private ProductPbq produce() {
        int shelfLife = new Random().nextInt(3) + 3;
        return new ProductPbq("Apple", shelfLife);
    }
}
