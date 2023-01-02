package utilconcurrent.collections.CopyOnWriteArraySet;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Stream;

public class CopyOnWriteArraySetExample {
    public static void main(String[] args) {
        // Create a CopyOnWriteArraySet object:
        Set<String> set = new CopyOnWriteArraySet<String>();
        set.add("A");
        set.add("B");
        set.add("C");

        Iterator<String> iterator1 = set.iterator();

        set.add("X1");
        set.add("X2");

        Iterator<String> iterator2 = set.iterator();

        System.out.println("--- Iterator 1: -----");
        while(iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        System.out.println("--- Iterator 2: -----");
        while(iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }

        // Stream
        Set<String> setStream = new CopyOnWriteArraySet<String>();
        set.add("A");
        set.add("B");
        set.add("C");

        Stream<String> stream1 = setStream.stream();

        set.add("X1");
        set.add("X2");

        Stream<String> stream2 = setStream.stream();

        System.out.println("--- Stream 1: -----");
        stream1.forEach(System.out::println);

        System.out.println("--- Stream 2: -----");
        stream2.forEach(System.out::println);
    }
}
