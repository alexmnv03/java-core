package collectionsframework.collections.list.arraylist;

import java.util.ArrayList;

public class ArrayListExample {

    public static void main(String[] args){
        System.out.println("java.util.ArrayList<E> Example ");
        ArrayList<String> listA = new ArrayList<>();

        //---------------------------------
        System.out.println("Добавление: ");

        // Устанавливает емкость массива, для хранения заданного количества элементов без изменения
        // внутреннего массива для хранения данных в памяти.
        listA.ensureCapacity(10);

        listA.add("a0");
        listA.add("a1");
        System.out.println("- в конец: " + listA);

        listA.add(1, "a2");
        System.out.println("- по индексу: " + listA);

        //---------------------------------
        System.out.println("Получение элементов и информации: ");

        System.out.print("- каждого элемента (for each): ");
        for (String el:listA){
            System.out.print(el+" ");
        }
        System.out.println();

        System.out.println("- элемента по индексу: " + listA.get(1));

        System.out.println("- размер: " + listA.size());

        //---------------------------------
        System.out.println("Изменение: ");

        listA.set(1, "c1");
        System.out.println("- по индексу: " + listA);

        // Сокращает емкость списочного массива до его текущего размера
        listA.trimToSize();

        //---------------------------------
        System.out.println("Удаление: ");

        listA.remove(1);
        System.out.println("- по индексу: " + listA);
    }
}
