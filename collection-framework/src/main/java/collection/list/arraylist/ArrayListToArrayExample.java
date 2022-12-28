package collection.list.arraylist;

import java.util.Arrays;
import java.util.List;

/**
 * Преобразование списка в массив
 */
public class ArrayListToArrayExample {

    // Java-программа для перебора списка
    public static void main(String[] args)
    {
        List<String> list = Arrays.asList("C", "C++", "Java");

        String[] array = null;

        // 1. Использование метода `List.toArray(T[])`
        array = list.toArray(new String[list.size()]);
        System.out.println(Arrays.toString(array));

        // 2. `List.toArray(T[])` — без выделения памяти
        array = list.toArray(new String[0]);
        System.out.println(Arrays.toString(array));

        // 3. Использование метода `List.toArray()`
        System.out.println(Arrays.toString(list.toArray()));

        // 4. Java 8 — потоки + ссылки на методы
        array = list.stream().toArray(String[]::new);
        System.out.println(Arrays.toString(array));

        // 5. Java 8 — потоки + лямбда-выражения
        array = list.stream().toArray(n -> new String[n]);
        System.out.println(Arrays.toString(array));

        // 6. Использование класса `FluentIterable` из библиотеки Guava
        //        array = FluentIterable.from(list).toArray(String.class);
        System.out.println(Arrays.toString(array));

        // 7. Использование класса `Iterables` из библиотеки Guava
        // array = Iterables.toArray(list, String.class);
        System.out.println(Arrays.toString(array));
    }
}
