package collections.CopyOnWriteArrayList;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;

/**
 * В этом примере мы видим, что если итератор создан до использования любого действия с
 * коллекцией, то мы уже не видим этих изменений.
 */
public class CopyOnWriteArrayListExample {
    public static void main(String[] args) {
        // Create a CopyOnWriteArrayList object:
        List<String> list = new CopyOnWriteArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");

        Iterator<String> iterator1 = list.iterator();

        list.add("X1");
        list.add("X2");

        Iterator<String> iterator2 = list.iterator();

        System.out.println("--- Iterator 1: -----");
        while(iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        System.out.println("--- Iterator 2: -----");
        while(iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }

        //Это правило работает если исползовать stream
        // Create a CopyOnWriteArrayList object:
        List<String> listStream = new CopyOnWriteArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");

        Stream<String> stream1 = listStream.stream();

        list.add("X1");
        list.add("X2");

        Stream<String> stream2 = listStream.stream();

        System.out.println("--- Stream 1: -----");
        stream1.forEach(System.out::println);

        System.out.println("--- Stream 2: -----");
        stream2.forEach(System.out::println);


    }
}
