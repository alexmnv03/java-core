package queues.blocking.PriorityBlockingQueue;

import java.util.Comparator;

/**
 * Класс ProductComparator используется для сравнения объектов Product. Продукт с большим сроком
 * годности считается большим. Продукт с наименьшим сроком годности будет стоять во главе очереди.
 */
public class ProductComparator implements Comparator<ProductPbq> {

    @Override
    public int compare(ProductPbq o1, ProductPbq o2) {
        return o1.getShelfLife() - o2.getShelfLife();
    }
}
