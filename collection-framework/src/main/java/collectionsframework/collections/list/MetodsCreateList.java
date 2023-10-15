package collectionsframework.collections.list;

import java.util.*;

/**
 * Различные способы создания коллекций
 */
public class MetodsCreateList {
    public static void main(String[] args) {
        Collection<Integer> collection =
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(collection);
        collection.add(125);
        System.out.println(collection);

        Collection<Integer> collect = new ArrayList<>();
        Integer[] moreInts = { 6, 7, 8, 9, 10 };
        collect.addAll(Arrays.asList(moreInts));
        System.out.println(collect);
        // Самый быстрый способ добавления элементов, но не настолько гибок, т.к. в том случае можно добавлять только другие коллекции
        Collection<Integer> collectFast = new ArrayList<>();
        Collections.addAll(collection, 11, 12, 13, 14, 15);
        Collections.addAll(collection, moreInts);
        // Produces a list "backed by" an array:
        List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
        list.set(1, 99); // OK -- modify an element

        Collection<Integer> collectionOf =
                new ArrayList<>(List.of(3, 1, 5));
        System.out.println(collectionOf);
    }
}
