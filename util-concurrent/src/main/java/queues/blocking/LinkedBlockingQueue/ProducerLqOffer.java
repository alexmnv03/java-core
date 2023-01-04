package queues.blocking.LinkedBlockingQueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Здесь, используя offer() метод: если очередь заполнена, производитель будет ждать до
 * указанного времени, прежде чем сдаться, вместо того, чтобы ждать, пока освободится место
 * в случае put() метод.
 * Если тайм-аут заканчивается без свободного места, никаких действий предпринято не будет,  и
 * метод вернет значение false.
 */
public class ProducerLqOffer implements Runnable {
    private static final Integer COUNT_PRODUCER = 50;

    private BlockingQueue<Integer> queue;

    public ProducerLqOffer (BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            for (int i = 0; i < 50; i++) {
                Integer number = produce();
                boolean success = queue.offer(number, 100, TimeUnit.MILLISECONDS);
                if (success) {
                    System.out.println("PRODUCER: created " + number);
                } else {
                    System.out.println("PRODUCER: gave up");
                }
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
