package interactionOfTthreads;

public class Joining {
    public static void main(String[] args) throws InterruptedException {
        Sleeper sleepy = new Sleeper("Sleepy", 25000);
        Sleeper grumpy = new Sleeper("Grumpy", 35000);
        // Этот поток будет ждать поток sleepy
        Joiner dopey = new Joiner("Dopey", sleepy);
        // Этот поток будет ждать поток grumpy
        Joiner doc = new Joiner("Doc", grumpy);
        // Искуственно прерываем поток после чего поток doc тоже будет завершен
        Thread.sleep(5000);
        grumpy.interrupt();
    }
}

class Sleeper extends Thread {
    private int duration;
    public Sleeper(String name, int sleepTime) {
        super(name);
        duration = sleepTime;
        start();
    }
    public void run() {
        try {
            // усыпим поток
            sleep(duration);
        } catch(InterruptedException e) {
            System.out.println(getName() + " was interrupted (был прерван). " +
                    "isInterrupted(): " + isInterrupted());
            return;
        }
        System.out.println(getName() + " has awakened (проснулся)");
    }
}

class Joiner extends Thread {
    private Sleeper sleeper;
    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }
    public void run() {
        try {
            sleeper.join();
        } catch(InterruptedException e) {
            System.out.println("Interrupted (прерван)");
        }
        System.out.println(getName() + " join completed (присоединение завершено)");
    }
}

