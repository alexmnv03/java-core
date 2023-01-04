package queues.blocking.LinkedBlockingQueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Здесь, используя poll() метод: если очередь пуста, потребитель будет ждать до указанного
 * времени, прежде чем отказаться, вместо того, чтобы ждать, пока освободится место в случае
 * take() метод. Если время ожидания заканчивается без доступных элементов, метод вернет
 * значение null.
 */
public class ConsumerLqPool implements Runnable {
    private BlockingQueue<Integer> queue;

    public ConsumerLqPool(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while (true) {
                Integer number = queue.poll(100, TimeUnit.MILLISECONDS);
                if (number != null) {
                    if (number == -1) {
                        System.out.println("Consumer: STOPPED.");
                        break;
                    }
                    consume(number);
                } else {
                    System.out.println("Consumer: gave up");
                }
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    /**
     * Засыпаем на случайное число в пределах 1 сек
     * @param number
     */
    private void consume(Integer number) {
        // fake consuming time
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException ie) { ie.printStackTrace(); }

        System.out.println("Consumer: processed " + number);
    }
}
