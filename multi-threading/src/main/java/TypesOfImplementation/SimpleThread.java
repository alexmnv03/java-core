package TypesOfImplementation;

// Испольуем наследование непосредственно от Thread.
public class SimpleThread extends Thread {
    private int countDown = 5;
    private static int threadCount = 0;
    public SimpleThread() {
        // Задаем имя потоку:
        super(Integer.toString(++threadCount));
    }
    public String toString() {
        return "#" + getName() + "(" + countDown + "), ";
    }
    public void run() {
        while(true) {
            System.out.print(this);
            if(--countDown == 0)
                return;
        }
    }
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++)
            new SimpleThread().start();
    }
}
