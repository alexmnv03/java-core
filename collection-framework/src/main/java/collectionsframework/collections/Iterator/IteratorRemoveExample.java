package collectionsframework.collections.Iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * При обходе элементов of Collection с помощью Iterator, вы можете удалить текущий элемент из
 * Collection.  Метод Iterator.remove() позволяет это сделать. Однако не все Iterator
 * поддерживают эту операцию, это зависит от типа Collection. Если он не поддерживается, будет
 * выдано исключение UnsupportedOperationException.
 */
public class IteratorRemoveExample {
    public static void main(String[] args) {
        // List is a subinterface of Collection.
        List<Integer> years = new ArrayList<Integer>();

        years.add(1998);
        years.add(1995);
        years.add(2000);
        years.add(2006);
        years.add(2021);

        Iterator<Integer> iterator = years.iterator();

        while(iterator.hasNext()) {
            Integer current = iterator.next();

            if(current % 2 ==0) {
                iterator.remove(); // Remove current element.
            }
        }
        // After remove all even numbers:
        for(Integer year: years)  {
            System.out.println(year);
        }

        // А вот с этим списком данная функция работать не будет
        // Fixed-size List.
        // Its Iterator does not support remove() operation.
        List<Integer> yearsAs = Arrays.asList(1998, 1995, 2000, 2006, 2021);

        Iterator<Integer> iteratorAs = yearsAs.iterator();

        while(iteratorAs.hasNext()) {
            Integer current = iteratorAs.next();

            if(current % 2 ==0) {
                iteratorAs.remove(); // UnsupportedOperationException!!
            }
        }
        // After remove all even numbers:
        for(Integer year: yearsAs)  {
            System.out.println(year);
        }
    }
}
