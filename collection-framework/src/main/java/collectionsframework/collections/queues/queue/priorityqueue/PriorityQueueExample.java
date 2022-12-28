package collectionsframework.collections.queues.queue.priorityqueue;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueExample {

    public static void main(String[] args){
        System.out.println("java.util.PriorityQueue<E> Example ");
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        //---------------------------------
        System.out.println("Добавление: ");

        pq.add(4);
        pq.add(2);
        pq.offer(3);
        pq.offer(1);
        System.out.println("- методами add(), offer(): " + pq);

        //---------------------------------
        System.out.println("Получение элементов и информации: ");

        System.out.print("- каждого элемента (for each): ");
        for (int el:pq){
            System.out.print(el+" ");
        }
        System.out.println();
        System.out.println("- peek() получим головной элемент без его удаления: " + pq.peek());

        System.out.println("- element() головного элемента : " + pq.element() );

        int val = 3;
        System.out.println("- contains(e) содержит элемент  [" + val + "]: " + pq.contains(val) );

        System.out.println("- size() размер: " + pq.size() );

        //---------------------------------
        System.out.println("Работа с итератором: ");

        System.out.print("- метод iterator(): ");
        Iterator<Integer> iter = pq.iterator();
        while(iter.hasNext()){
            System.out.print(iter.next() + " ");
        }
        System.out.println();

        //---------------------------------
        System.out.println("Удаление / извлечение : ");
        pq.add(0);
        pq.add(1);
        pq.add(2);
        System.out.println("  Начальное состояние: " + pq);

        System.out.println("- remove() возвращает и удаляет головной элемент из головы [" + pq.remove() + "] => " + pq);

        System.out.println("- poll() возвращает и удаляет головной элемент [" + pq.poll() + "] => " + pq);

        val = 2;
        pq.remove(val);
        System.out.println("- по значению ["+ val +"] => " + pq);

        pq.clear();
        System.out.println("- очистка clear() => " + pq);

        //---------------------------------
        System.out.println("Использование собственного класса сравнения Comparator: ");

        PriorityQueue<Integer> pqc = new PriorityQueue<>(new CustomComparator());
        pqc.add(2);
        pqc.add(0);
        pqc.add(1);

        System.out.println("- содержание очереди: " + pqc);

        System.out.print("- извлечение элементов: ");
        while (pqc.size() > 0) {
            System.out.print(pqc.poll() + " ");
        }
    }

}

// Собственный класс сравнения
class CustomComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer number1, Integer number2) {
        int val =  number1.compareTo(number2);
        // элементы сортируются в обратном порядке
        if (val > 0) {
            return -1;
        }
        else if (val < 0) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
