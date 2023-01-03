package queues.blocking.LinkedTransferQueue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * Следующий пример демонстрирует применение очереди LinkedTransferQueue. В примере содаются два
 * потока, работающие с очередью TransferQueue<String>. Поток производитель Producer размещает
 * элемент в очереди с использованием метода transfer. Поток потребитель Consumer извлекает
 * элементы из очереди и выводит их в консоль. Перед получением элемента из очереди Consumer
 * делает небольшую задержку, по которой можно оценить, кто кого ожидает, т.е. какой поток
 * блокируется очередью. Перед каждой операции с очередью и после выполнения операции потоки
 * выводят соответствующие сообщения в консоль с указанием времени.
 */
public class LinkedTransferQueueExample {

    TransferQueue<String> queue = null;

    String WAIT_producer = "Producer waiting to transfer : ";
    String TRANSFERED    = "Producer transfered :"          ;

    String WAIT_consumer = "Consumer waiting to consumed : ";
    String CONSUMED      = "Consumer consumed : "           ;

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    public LinkedTransferQueueExample()
    {
        queue = new LinkedTransferQueue<String>();

        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
    }
    void printMessage(final String msg)
    {
        String text = sdf.format(new Date()) + " " + msg;
        System.out.println(text);
    }

    class Producer implements Runnable{
        @Override
        public void run() {
            for(int i = 0; i < 2; i++){
                try{
                    printMessage(WAIT_producer + i);
                    queue.transfer("'producer-" + i + "'");
                    printMessage(TRANSFERED + i + "\n");
                } catch(Exception e){}
            }
        }

    }
    class Consumer implements Runnable{
        @Override
        public void run() {
            for(int i = 0; i < 2; i++){
                try{
//                    Thread.sleep(2000);
                    printMessage(WAIT_consumer + i);
                    String element = queue.take();
                    printMessage(CONSUMED + element);
                }catch(Exception e){}
            }
        }
    }

    public static void main(String args[]) {
        new LinkedTransferQueueExample();
    }
}
