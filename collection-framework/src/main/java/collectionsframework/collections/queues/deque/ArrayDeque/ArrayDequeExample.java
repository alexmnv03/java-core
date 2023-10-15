package collectionsframework.collections.queues.deque.ArrayDeque;

import java.util.ArrayDeque;
import java.util.Iterator;

public class ArrayDequeExample {

    public static void main(String[] args){
        System.out.println("java.util.ArrayDeque<E> Example ");
        String val;
        ArrayDeque<String> ad1 = new ArrayDeque<>();

        //---------------------------------
        System.out.println("Добавление в очередь 1 методами add(), addFirst(), addLast(): ");

        ad1.addFirst("a0");
        //добавление в конец - наличие двух методов свзяано с наследованием от двух интерфейсов
        ad1.add("a1");
        ad1.addLast("a2");
        System.out.println("- в конец и начало: " + ad1);

        ArrayDeque<String> ad2 = new ArrayDeque<>();
        ad2.offerFirst("b0");
        ad2.offer("b1");
        ad2.offerLast("b2"); //добавление в конец
        System.out.println("Добавление в очередь 2 методами offer(), offerFirst(), offerLast(): " + ad2);

        //add(E e) имеет возможность генерировать исключение, если элемент не может быть добавлен
        // в очередь. Это происходит в случае, если очередь заполнена.

        //offer(E e) вернет специальное значение (в данном случае логическое), если значение не
        // может быть добавлено в очередь. Это полезно, если вы имеете дело с очередью с
        // ограниченным размером, но не хотите создавать исключение.

        ad1.addAll(ad2);
        System.out.println("Добавление очереди 2 в 1: " + ad1);

        //---------------------------------
        System.out.println("Получение элементов и информации: ");

        System.out.print("- каждого элемента (for each): ");
        for (String el:ad1){
            System.out.print(el+" ");
        }
        System.out.println();

        System.out.println("- первого getFirst() и последнего getLast() элемента: "
                + ad1.getFirst()+" "+ad1.getLast());
        System.out.println("- первого peek(), peekFirst() и последнего элемента peekLast(): "
                + ad1.peek() + " " + ad1.peekFirst() + " " +ad1.peekLast());

        System.out.println("- элемента из головы element(): " + ad1.element() );

        val = "b0";
        System.out.println("- содержит элемент contains(e) [" + val + "]: " + ad1.contains(val) );

        System.out.println("- размер size(): " + ad1.size() );
        //---------------------------------
        System.out.println("Удаление (получение): ");
        ad1.add("c0");
        ad1.add("c1");
        ad1.add("c2");
        System.out.println("  Начальное состояние: " + ad1);

        System.out.println("- remove() возвращает и удаляет первый элемент [" + ad1.remove() + "] > " + ad1);
        System.out.println("- в начале removeFirst() [" + ad1.removeFirst() + "] и конце removeLast() [" + ad1.removeLast() + "] > " + ad1);

        System.out.println("- poll() возвращает и удаляет первый элемент [" + ad1.poll() + "] > " + ad1);
        System.out.println("- в начале pollFirst() [" + ad1.pollFirst() + "] и конце pollLast() [" + ad1.pollLast() + "] > " + ad1);

        val = "c0";
        ad1.remove(val);
        System.out.println("- по значению ["+ val +"] > " + ad1); // медленно

        ad1.clear();
        System.out.println("- очистка clear() > " + ad1);

        //---------------------------------
        System.out.println("Работа с итератором: ");

        // Итератор. Добавляется здесь иначе возникнет исключение ConcurrentModificationException
        // , поспольку итератор обнаружит, что коллекция была модифицирована другим итератором
        //   или же методом самой коллекции

        System.out.print("- в прямом порядке iterator(): ");
        Iterator<String> iter = ad2.iterator();
        while(iter.hasNext()){
            System.out.print(iter.next() + ", ");
        }

        System.out.print("\n- в обратном порядке descendingIterator(): ");
        // Using descendingIterator()
        Iterator<String> desIter = ad2.descendingIterator();
        while(desIter.hasNext()) {
            System.out.print(desIter.next());
            System.out.print(", ");
        }
    }
}
