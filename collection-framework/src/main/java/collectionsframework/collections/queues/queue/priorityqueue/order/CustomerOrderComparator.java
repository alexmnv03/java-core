package collectionsframework.collections.queues.queue.priorityqueue.order;

import java.util.Comparator;

/**
 * Допустим в другой части приложения нам необходимо использовать другой вариант сортировки очереди
 * Для этого создадим пользовательскуий компаратор в котором приоритеты будут на основе порядка
 * убывания orderAmount .
 */
class CustomerOrderComparator implements Comparator<CustomerOrder> {

    @Override
    public int compare(CustomerOrder o1, CustomerOrder o2)
    {
        return o1.getOrderAmount() < o2.getOrderAmount() ? 1 : -1;
    }
}
