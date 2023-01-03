package queues.blocking.LinkedBlockingQueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * В цикле создаем COUNT_PRODUCER объектов и помещаем их в очередь
 */
public class ProducerLQ implements Runnable {

    private static final Integer COUNT_PRODUCER = 50;

    private BlockingQueue<Integer> queue;

    public ProducerLQ (BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            for (int i = 0; i < COUNT_PRODUCER; i++) {
                Integer number = produce();
                queue.put(number);
                System.out.println("PRODUCER: created " + number);
            }
            queue.put(-1);       // indicates end of producing
            System.out.println("PRODUCER: STOPPED.");
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    private Integer produce() {
        Random random = new Random();
        Integer number = random.nextInt(100);
        // fake producing time
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException ie) { ie.printStackTrace(); }


        return number;
    }
}
