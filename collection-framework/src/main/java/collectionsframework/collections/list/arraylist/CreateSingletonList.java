package collectionsframework.collections.list.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Если нам необходимо создать список только для чтения, но мы хотим передать в него только один элемент, то иметется такой метод как.
 * Collections.SingletonList создаст неизменный список.
 * Он Возвращает неизменный список, содержащий только указанный объект.
 * Методы добавления или удаления элементов будут вызывать исключения, если вы попытаетесь изменить содержимое.
 * singletonList является потоко-безопасным и быстрым.
 *
 */
public class CreateSingletonList {

    public static void main(String[] args) {
        List list = Collections.singletonList("OnlyOneElement");
        list.add("five"); // получаем ошибку throws UnsupportedOperationException
        // С его помощью можно удалять одинаковые элементы из списка
        String[] array = { "1", "2", "4", "2", "1", "2", "3", "1", "3", "4", "3", "3" };
        List listWithoutSingleton = new ArrayList(Arrays.asList(array));
        System.out.println("Original listNoSingleton:                            " + listWithoutSingleton);

        listWithoutSingleton.remove("1");
        System.out.println("список после удаления элемента '1' из списка         " + listWithoutSingleton);
        listWithoutSingleton.remove("1");
        System.out.println("список после удаления второго элемента '1' из списка " + listWithoutSingleton);
        listWithoutSingleton.remove("2");
        System.out.println("список после удаления элемента '2' из списка         " + listWithoutSingleton);
        /* А теперь тоже самое только для удаления используем singleton() method */
        List listWithSingleton = new ArrayList(Arrays.asList(array));
        System.out.println(" Original listWithSingleton:                 " + listWithSingleton);

        listWithSingleton.removeAll(Collections.singleton("1"));
        System.out.println("список после удаления элемента '1' из списка " + listWithSingleton);

        listWithSingleton.removeAll(Collections.singleton("4"));
        System.out.println("список после удаления элемента '4' из списка " + listWithSingleton);

        listWithSingleton.removeAll(Collections.singleton("3"));
        System.out.println("список после удаления элемента '3' из списка " + listWithSingleton);
    }

}
