package collection.set.linkedhashset;

import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * Пример использования хэш-множества Class LinkedHashSet<E>
 */
public class LinkedHashSetExample {
    public static void main(String[] args){
        System.out.println("java.util.LinkedHashSet<E> Example ");

        // Создаем множество c емкостью 4 и коэффициентом заполнения 0.9
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>(4, 0.9f);
        // Создаем множество по умолчанию с емкостью 16 и коэффициентом заополнения 0.75
        LinkedHashSet<Integer> lhsZero = new LinkedHashSet<>();

        System.out.println("Добавление");
        // Добавляем определенные элементы в множество
        lhs.add(1);
        lhs.add(2);
        lhs.add(3);
        System.out.println("- с использование add() в lhs: " + lhs);

        lhsZero.add(null);
        lhsZero.add(0);
        lhsZero.addAll(lhs);
        System.out.println("- с использование addAll() в lhsZero: " + lhsZero);

        // Получение
        System.out.println("Получение");
        // Возвращает итератор по элементам множества.
        Iterator<Integer> iterLhs = lhs.iterator();
        System.out.print("- итератор по lhs: ");
        while (iterLhs.hasNext())
            System.out.print(" " + iterLhs.next());
        System.out.println();

        // Другое
        System.out.println("Другое");
        // Количесво элементов множества
        System.out.println("- количество: " + lhs.size());
        // Возвращает true, если множество содержит заданный элемент.
        System.out.println("- содержит 1: " + lhs.contains(1));
        // Возвращает true если множетво пустое.
        System.out.println("- пустое: " + lhs.isEmpty());
        // Пересечение множеств.
        // Метод retainAll() осталяет во множестве только те значения,
        // которые есть в переданном множестве, остальное удаляется.
        lhs.add(4);
        System.out.println("- множества lhs " + lhs + " и lhsZero " + lhsZero);
        lhs.retainAll(lhsZero);
        System.out.println("  пересечение множеств lhs и lhsZero: " + lhs);
        // Подмножество
        System.out.println("- lhs подмножество lhsZero: " + lhsZero.containsAll(lhs));

        // Удаление
        System.out.println("Удаление");
        // Удаляет заданный элемент из множества, если он есть.
        lhs.remove(2);
        System.out.println("- с использованием remove() удаляем 2 из lhs:" + lhs);
        lhsZero.removeAll(lhs);
        System.out.println("- с использованием removeAll() удаляем из lhsZero: " + lhsZero);
        lhsZero.clear();
        System.out.println("- очистка clear() в lhsZero: " + lhsZero);
    }
}
