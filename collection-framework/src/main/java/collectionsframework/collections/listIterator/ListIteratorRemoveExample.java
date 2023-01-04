package collectionsframework.collections.listIterator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Удаляем элементы по условию и получаем из оставшихся отсортированный список
 */
public class ListIteratorRemoveExample {
    public static void main(String[] args)  {
        List<Integer> list= new ArrayList<Integer>();

        list.add(11);
        list.add(55);
        list.add(22);
        list.add(77);
        list.add(33);
        list.add(99);
        list.add(11);

        ListIterator<Integer> listIter = list.listIterator();

        int temp = listIter.next();

        while(listIter.hasNext())  {
            int current = listIter.next();

            if(current < temp)  {
                listIter.remove();
            } else {
                temp = current;
            }
        }

        for(Integer value: list)  {
            System.out.println(value);
        }
    }
}
