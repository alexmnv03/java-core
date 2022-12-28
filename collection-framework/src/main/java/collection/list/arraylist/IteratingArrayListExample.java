package collection.list.arraylist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Рассмотрим различные способы перебора элементов списка
 */
public class IteratingArrayListExample {

    public static void main(String[] args){

        List<String> countries = Arrays.asList("Russian", "Germany", "Panama", "Australia");

        // 1. Базовый цикл for
        for (int i = 0; i < countries.size(); i++) {
            System.out.println(countries.get(i));
        }

        // 2. Улучшенный цикл for
        for (String country : countries) {
            System.out.println(country);
        }

        // 3. Iterator стандартный итератор
        Iterator countriesIterator = countries.iterator();

        while(countriesIterator.hasNext()) {
            System.out.println(countriesIterator.next());
        }

        // 4. ListIterator специальный итератор для коллекции List, что обеспечивает
        // двунаправленный доступ в дополнение к обычным операциям, которые Iterator обеспечивает интерфейс.
        ListIterator listIterator = countries.listIterator();

        while(listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
        // и в обратном направлении
        // Iterate in reverse.
        while(listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }

        // 5. forEach - все классы, реализующие Iterable, имеют добавленную функцию forEach.
        countries.forEach( (s) -> System.out.println(s) );
        // или более короткий вариант
        countries.forEach(System.out::println);

        // 6. Stream.forEach
        countries.stream().forEach((s) -> System.out.println(s));

    }
}
