package queues.blocking.example;

/**
 * Продукт
 */
public class Product {
    private String name;
    private int serial;

    public Product(String name, int serial) {
        this.name = name;
        this.serial = serial;
    }
    public String getInfo() {
        return "Product: " + this.name + ". Serial: " + this.serial;
    }
}
