package collectionsframework.map.WeakHashMap;

import java.util.HashMap;
import java.util.WeakHashMap;

public class WeakHashMapExample {
    public static void main(String[] args) {
        // Создание WeakHashMap
        WeakHashMap<String, Integer> numbersWHM = new WeakHashMap<>();

        String oneW = new String("Один");
        Integer oneValueW = 1;
        String twoW = new String("Два");
        Integer twoValueW = 2;

        // Добавление элементов
        numbersWHM.put(oneW, oneValueW);
        numbersWHM.put(twoW, twoValueW);
        System.out.println("Содержание WeakHashMap: " + numbersWHM);

        // Убираем ссылку на объект элемента
        twoW = null;

        // Выполняем сборку мусора
        System.gc();

        System.out.println("Содержание WeakHashMap после сборки мусора: " + numbersWHM);

        //------------------------------------------------------------------------
        // Создание HashMap
        HashMap<String, Integer> numbersHM = new HashMap<>();

        String one = new String("Один");
        Integer oneValue = 1;
        String two = new String("Два");
        Integer twoValue = 2;

        // Добавление элементов
        numbersHM.put(one, oneValue);
        numbersHM.put(two, twoValue);
        System.out.println("Содержание HashMap: " + numbersHM);

        // Убираем ссылку на объект элемента
        two = null;

        // Выполняем сборку мусора
        System.gc();

        System.out.println("Содержание HashMap после сборки мусора: " + numbersHM);

    }
}
