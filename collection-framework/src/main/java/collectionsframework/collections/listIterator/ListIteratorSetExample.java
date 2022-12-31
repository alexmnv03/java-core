package collectionsframework.collections.listIterator;

import java.util.*;

/**
 * При обходе  (traverse) элементов List с помощью ListIterator, вы можете обновить текущий
 * элемент.  Метод ListIterator.set(E) позволяет вам это сделать. Однако не все ListIterator
 * поддерживают эту операцию, это зависит от типа List. Если не он поддерживается, будет выдано
 * исключение UnsupportedOperationException.
 *
 */
public class ListIteratorSetExample {
    public static void main(String[] args)  {
        List<Integer> list= new ArrayList<Integer>();

        list.add(-111);
        list.add(555);
        list.add(-222);
        list.add(777);
        list.add(-333);
        list.add(999);
        list.add(111);

        ListIterator<Integer> listIter = list.listIterator();

        while(listIter.hasNext())  {
            int current = listIter.next();
            if(current < 0)  {
                listIter.set(0);
            }
        }

        for(Integer value: list)  {
            System.out.println(value);
        }

        // А вот с этим списком данная функция работать не будет
        List<Integer> aList = Arrays.asList(-111, 555,-222,777,-333,999,111);

        // UnmodifiableList
        // This list does not support "set" operation!
        List<Integer> unmodifiableList = Collections.unmodifiableList(aList);

        ListIterator<Integer> listIterAs = unmodifiableList.listIterator();

        int current = listIterAs.next();

        listIterAs.set(1000); // throw UnsupportedOperationException
    }
}
