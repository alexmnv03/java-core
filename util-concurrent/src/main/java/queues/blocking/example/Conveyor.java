package queues.blocking.example;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Conveyor {
    public static void main(String[] args) {
        // Create a BlockingQueue with a capacity of 5.
        BlockingQueue<Product> q = new ArrayBlockingQueue<Product>(5);
        Producer producer1 = new Producer("Producer 01", 2, q);
        Producer producer2 = new Producer("Producer 02", 1, q);
        Consumer consumer1 = new Consumer("Consumer 01", q);
        Consumer consumer2 = new Consumer("Consumer 02", q);
        Consumer consumer3 = new Consumer("Consumer 03", q);

        // Starting the threads
        new Thread(producer1).start();
        new Thread(producer2).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
        new Thread(consumer3).start();
    }
}
