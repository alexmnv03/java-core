package collection.set.hashset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {
    /**
     * Пример использования хэш-множества Class HashSet<E>
     */
    public static void main(String[] args){
        System.out.println("java.util.HashSet<E> Example ");

        // Создаем множество
        Set<String> hs = new HashSet<>();

        // Добавляем определенные элементы в множество.
        hs.add("hs0");
        hs.add("hs1");
        hs.add("hs2");

        System.out.println("После добавления: " + hs);

        // Количесво элементов множества
        System.out.println("Количество: " + hs.size());

        // Возвращает true, если множество содержит заданный элемент.
        System.out.println("Содержит hs1: " + hs.contains("hs1"));

        // Возвращает true если множество пустое.
        System.out.println("Пустое: " + hs.isEmpty());

        // Удаляет заданный элемент из множества, если он есть.
        hs.remove("hs0");
        System.out.println("После удаления hs0: " + hs);

        // Возвращает итератор по элементам множества.
        Iterator<String> iterHs = hs.iterator();
        System.out.println("Вывод с помощью итератора: ");
        while (iterHs.hasNext())
            System.out.print(" " + iterHs.next());

        // Удаляем все элементы из множества
        hs.clear();
    }
}

