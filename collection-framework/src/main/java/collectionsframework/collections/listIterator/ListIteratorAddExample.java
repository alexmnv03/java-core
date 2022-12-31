package collectionsframework.collections.listIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * При обходе (traverse) элементов List с помощью ListIterator, вы можете вставить элемент в List.
 * Метод ListIterator.add(E) позволяет вам это сделать. Однако не все ListIterator поддерживают
 * эту операцию, это зависит от типа List. Если он не поддерживается, будет выдано  исключение
 * UnsupportedOperationException.
 */
public class ListIteratorAddExample {
    public static void main(String[] args)  {
        List<String> list= new ArrayList<String>();

        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");

        ListIterator<String> listIter = list.listIterator();

        listIter.next(); // "One"
        listIter.next(); // "Two"
        listIter.next(); // "Three"
        listIter.previous(); // "Three"

        listIter.add("X1");


        for(String value: list)  {
            System.out.println(value);
        }


        // А вот с этим списком данная функция работать не будет
        // Fixed-size List
        // It does not support add or set operation.
        List<String> listAs = Arrays.asList("One","Two","Three","Four","Five");

        ListIterator<String> listIterAs = listAs.listIterator();

        listIterAs.next(); // "One"
        listIterAs.next(); // "Two"
        listIterAs.next(); // "Three"
        listIterAs.previous(); // "Three"

        listIterAs.add("X1"); // throw UnsupportedOperationException
    }
}
