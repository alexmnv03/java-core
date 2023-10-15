package collectionsframework.map.LinkedHashMap;

import java.util.LinkedHashMap;

public class LinkedHashMapExample {
    public static void main(String[] args){
        System.out.println("java.util.LinkedHashMap<K,V> Example ");

        // Создание LinkedHashMap с порядком вставки
        LinkedHashMap<Integer, String> numbers = new LinkedHashMap<>();

        // Добавление элементов
        numbers.put(1, "Один");
        numbers.put(2, "Два");
        numbers.put(3, "Три");
        System.out.println("Получение элемента numbers 1: " + numbers.get(1));
        System.out.println("Содержание numbers с порядком вставки: " + numbers);

        // Создание LinkedHashMap c порядком доступа
        LinkedHashMap<Integer, String> numbersAO =
                new LinkedHashMap<>(8, 0.75f, true);

        // Добавление элементов
        numbersAO.put(1, "Один");
        numbersAO.put(2, "Два");
        numbersAO.put(3, "Три");
        System.out.println("Получение элемента numbersAO 1: " + numbersAO.get(1));
        System.out.println("Содержание numbersAO с порядком доступа: " + numbersAO);
    }
}
