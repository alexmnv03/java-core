package collectionsframework.map.EnumMap;

import java.util.EnumMap;

public class EnumMapExample {
    // Создание перечисления дней недели
    enum Weekday {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}

    public static void main(String[] args){
        System.out.println("java.util.EnumMap<K extends Enum<K>,V> Example");

        // Создаем
        EnumMap<Weekday, Integer> weekday = new EnumMap<>(Weekday.class);
        weekday.put(Weekday.MONDAY, 1);
        weekday.put(Weekday.TUESDAY, 2);
        weekday.put(Weekday.WEDNESDAY, 3);
        weekday.put(Weekday.THURSDAY, 4);
        weekday.put(Weekday.FRIDAY, 5);
        weekday.put(Weekday.SATURDAY, 6);
        weekday.put(Weekday.SUNDAY, 7);

        System.out.println("Содержание EnumMap: " + weekday);
        System.out.println("Связки ключ-значение entrySet(): " + weekday.entrySet());
        System.out.println("Ключи keySet(): " + weekday.keySet());
        System.out.println("Значения values(): " + weekday.values());
    }
}
