package ExceptionThread;

import java.util.concurrent.*;

public class CaptureUncaughtException {
    public static void main(String[] args) {

        // Класс фабрика пердается методу Executors, который создает новый экземпляр ExecutorSeervice
        ExecutorService exec = Executors.newCachedThreadPool(
                new HandlerThreadFactory());
        exec.execute(new ExceptionThread2());
    }
}

class ExceptionThread2 implements Runnable {
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run() by " + t);
        System.out.println(
                "eh = " + t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}

class MyUncaughtExceptionHandler implements
        Thread.UncaughtExceptionHandler {
    // Этот метод вызывается автоматически тогда, когда поток закрывается из-за неперехваченного исключения.
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught " + e);
    }
}

/**
 * Чтобы исползовать интерфейс Thread.UncaughtExceptionHandler создадим новый тип Factory,
 * который присоединяет новый объект MyUncaughtExceptionHandler к каждому создаваемому объекту Thread.
 */
class HandlerThreadFactory implements ThreadFactory {
    public Thread newThread(Runnable r) {
        System.out.println(this + " creating new Thread");
        Thread t = new Thread(r);
        System.out.println("created " + t);
        t.setUncaughtExceptionHandler(
                new MyUncaughtExceptionHandler());
        System.out.println(
                "eh = " + t.getUncaughtExceptionHandler());
        return t;
    }
}

