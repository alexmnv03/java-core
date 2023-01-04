package queues.blocking.PriorityBlockingQueue;

public class ProductPbq {
    private String name;
    private int shelfLife;

    public ProductPbq(String name, int shelfLife) {
        this.name = name;
        this.shelfLife = shelfLife;
    }
    public int getShelfLife() {
        return shelfLife;
    }
    @Override
    public String toString() {
        return this.name + ":" + this.shelfLife;
    }
}
