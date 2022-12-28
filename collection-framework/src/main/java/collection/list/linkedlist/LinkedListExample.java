package collection.list.linkedlist;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListExample {

    public static void main(String[] args){
        System.out.println("java.util.LinkedList<E> Example ");
        LinkedList<String> listA = new LinkedList<>();

        //---------------------------------
        System.out.println("Добавление: ");

        listA.add("a0");
        listA.add("a1");
        System.out.println("- в конец: " + listA);

        listA.add(1, "a10"); // не рекомендуется работать по индексам
        System.out.println("- по индексу: " + listA);

        listA.addFirst("a0");
        listA.addLast("a2");
        System.out.println("- в конец и начало: " + listA);

        List<String> listB = new LinkedList<>();
        listB.add("b0");
        listB.add("b1");
        listB.add("b2");
        System.out.println("  Список B: " + listB);

        listA.addAll(listB);
        System.out.println("- списка B в A: " + listA);

        //---------------------------------
        System.out.println("Получение элементов и информации: ");

        System.out.print("- каждого элемента списка (for each): ");
        for (String el:listA){
            System.out.print(el+" ");
        }
        System.out.println();

        System.out.println("- элемента по индексу : " + listA.get(2));

        System.out.println("- первого и последнего элемента: " + listA.getFirst()+" "+listA.getLast());

        System.out.println("- первое и последняя позиция элемента: " + listA.indexOf("a0") + " " + listA.lastIndexOf("a0"));

        //---------------------------------
        System.out.println("Изменение: ");

        listA.set(4, "c4");
        System.out.println("- по индексу: " + listA);


        //---------------------------------
        System.out.println("Удаление: ");

        listA.removeFirst();
        listA.removeLast();
        System.out.println("- в начале и конце " + listA);

        listA.remove(0);
        System.out.println("- по индексу " + listA); // медленно

        listA.remove("a10");
        System.out.println("- по значению " + listA); // медленно

        //---------------------------------
        System.out.println("Работа с итератором: ");

        // Итератор. Добавляется здесь иначе возникнет исключение ConcurrentModificationException
        // , поскольку итератор обнаружит, что коллекция была модифицирована другим итератором
        //   или же методом самой коллекции
        ListIterator<String> iterA = listA.listIterator();

        iterA.next();
        iterA.add("i1");
        System.out.println("- добавление элемента: " + listA);

        iterA.next();
        iterA.set("i2");
        System.out.println("- изменение элемента: " + listA);

        iterA.previous();
        iterA.previous();
        iterA.previous();
        iterA.set("i0");
        System.out.println("- изменение элемента при движении назад: " + listA);

        System.out.println("- индекс следующего и предыдущего элемента: " + iterA.nextIndex() + " " + iterA.previousIndex());

        System.out.print("- перебор элементов: ");
        while(iterA.hasNext()){
            String element = iterA.next();
            System.out.print(element + " ");
        }
        System.out.println();

        System.out.print("- перебор в обратном порядке: ");
        while(iterA.hasPrevious()){
            System.out.print(iterA.previous()+" ");
        }
        System.out.println();
    }
}
