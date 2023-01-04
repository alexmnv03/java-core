package queues.blocking.PriorityBlockingQueue;

import java.util.Comparator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueExample {
    public static void main(String[] args) {
        // Comparator
        Comparator<ProductPbq> comparator = new ProductComparator();
        // Create a PriorityBlockingQueue with a capacity of 100.
        BlockingQueue<ProductPbq> queue = new PriorityBlockingQueue<ProductPbq>(100, comparator);
        queue.add(new ProductPbq("Banana", 5));
        queue.add(new ProductPbq("Banana", 2));
        queue.add(new ProductPbq("Banana", 7));
        queue.add(new ProductPbq("Banana", 3));
        queue.add(new ProductPbq("Banana", 1));

        ProducerPbq producer1 = new ProducerPbq("Producer 01", 2, queue);
        ProducerPbq producer2 = new ProducerPbq("Producer 02", 3, queue);

        ConsumerPbq consumer1 = new ConsumerPbq("Consumer 01", queue);
        ConsumerPbq consumer2 = new ConsumerPbq("Consumer 02", queue);
        ConsumerPbq consumer3 = new ConsumerPbq("Consumer 03", queue);

        // Starting Producer threads
        new Thread(producer1).start();
        new Thread(producer2).start();
        // Starting Consumer threads
        new Thread(consumer1).start();
    }
}
