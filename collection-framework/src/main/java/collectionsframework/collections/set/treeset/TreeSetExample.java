package collectionsframework.collections.set.treeset;

import java.util.Iterator;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Пример использования древовидного множества Class TreeSet<E>
 */
public class TreeSetExample {

    public static void main(String[] args){
        System.out.println("java.util.TreeSet<E> Example ");

        // Создаем множество
        TreeSet<String> ts = new TreeSet<>();

        // Добавляем определенные элементы в множество, если их еще небыло.
        ts.add("ts0");
        ts.add("ts1");
        ts.add("ts2");

        System.out.println("После добавления: " + ts);

        // Количесво элементов множества
        System.out.println("Количество: " + ts.size());

        // Возвращает true, если множество содержит заданный элемент.
        System.out.println("Содержит ts1: " + ts.contains("ts1"));

        // Возвращает true если множество пустое.
        System.out.println("Пустое: " + ts.isEmpty());

        // Удаляет заданный элемент из множества, если он есть.
        ts.remove("ts0");
        System.out.println("После удаления ts0: " + ts);

        // Возвращает итератор по элементам множества.
        Iterator<String> iterTs = ts.iterator();
        System.out.println("Вывод с помощью итератора: ");
        // Рассмотрим различные способы перебора
        while (iterTs.hasNext())
            System.out.print(" " + iterTs.next());

        for (String value: ts)
            System.out.print(" " + value);

        // Using forEach
        ts.forEach(iterator -> System.out.print(iterator + " "));

        // Using stream
        ts.stream().map(iterator -> String.valueOf(iterator)).collect(Collectors.joining(", "));
        ts.stream().map(String::valueOf).collect(Collectors.joining(", "));

        // Удаляем все элементы из множества
        ts.clear();
    }
}

