package collection.set.enumset;

import java.util.EnumSet;
import java.util.Iterator;

/**
 * Пример использования перечислимого множества Class EnumSet<E extends Enum<E>>
 */
public class EnumSetExample {
    // Создание перечисления дней недели
    enum Weekday {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}

    public static void main(String[] args){
        System.out.println("java.util.EnumSet<E extends Enum<E>> Example");

        // Создаем множество
        EnumSet<Weekday> allweek = EnumSet.allOf(Weekday.class);
        EnumSet<Weekday> never = EnumSet.noneOf(Weekday.class);
        EnumSet<Weekday> workday = EnumSet.range(Weekday.MONDAY, Weekday.FRIDAY);
        EnumSet<Weekday> hardday = EnumSet.of(Weekday.MONDAY);

        System.out.println("После создания: " + allweek);
        System.out.println("После создания: " + never);
        System.out.println("После создания: " + workday);
        System.out.println("После создания: " + hardday);

        // Добавление
        System.out.println("Добавление");

        hardday.add(Weekday.SATURDAY);
        System.out.println("- с использованием add(): " + hardday);
        hardday.addAll(workday);
        System.out.println("- с использованием addAll(): " + hardday);

        // Получение
        System.out.println("Получение");
        Iterator<Weekday> iterate = allweek.iterator();

        System.out.print("- итератор: ");
        while(iterate.hasNext()) {
            System.out.print(iterate.next() + " ");
        }
        System.out.println("");

        // Удаление
        System.out.println("Удаление");

        hardday.remove(Weekday.TUESDAY);
        System.out.println("- с использованием remove(): " + hardday);
        hardday.removeAll(workday);
        System.out.println("- с использованием removeAll(): " + hardday);

        hardday.clear();
        System.out.println("- очистка clear(): " + hardday);

        // Другое
        System.out.println("Другое");

        EnumSet<Weekday> allweekCopy = EnumSet.copyOf(allweek); // копирование множества
        System.out.println("- создание копии copyOf(): " + allweekCopy);
        System.out.println("- поиск элемента contains(): " + allweekCopy.contains(Weekday.MONDAY));
        System.out.println("- проверка пустого множества isEmpty(): " + allweekCopy.isEmpty());
        System.out.println("- размер множества size(): " + allweekCopy.size());
    }
}
