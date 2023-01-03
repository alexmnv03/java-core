package queues.blocking.LinkedBlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueExample {

    private static final Integer COUNT_QUEUE = 20;

    public static void main(String[] args) throws InterruptedException {

        // Создаем очередь размером COUNT_QUEUE
        // В начале производитель быстро заполняет очередь, чтобы достичь ее емкости. Тогда
        // производитель и потребитель работают в тандеме, поскольку очередь заполнена,
        // производитель может поместить новый элемент в очередь только в том случае, если
        // потребитель обработает и удалит его.
        //И в конце производитель останавливается первым, а потребитель обрабатывает оставшиеся
        // элементы в очереди.
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(COUNT_QUEUE);
        Thread producer = new Thread(new ProducerLQ(queue));
        Thread consumer = new Thread(new ConsumerLQ(queue));
        producer.start();
        consumer.start();

        // Расмотрим пример когда производитель сначала ждет указанное время перед добавлением
        // элемента, если очередь заполнена и если спустя указанное время она будет все еще
        // заполнена, то элемент не будет добавлен. Такой алгоритм и у потребителя, спучтя
        // указанное время он вернет null, если очередь все еще путая
        Thread.sleep(30000);
        System.out.println("PRODUCER: Offer + Consumer: Pool");
        BlockingQueue<Integer> queueTimeOut = new LinkedBlockingQueue<>(COUNT_QUEUE);
        Thread producerLqOffer = new Thread(new ProducerLqOffer(queueTimeOut));
        Thread consumerLqPool = new Thread(new ConsumerLqPool(queueTimeOut));
        producerLqOffer.start();
        consumerLqPool.start();

    }
}
