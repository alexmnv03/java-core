package collectionsframework.collections.listIterator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorIterable {
    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");

        // Create ListIterator.
        ListIterator<String> listIterator = list.listIterator();

        String first = listIterator.next();
        System.out.println("First:" + first);// -->"One"

        String second = listIterator.next();
        System.out.println("Second:" + second);// -->"Two"

        if (listIterator.hasPrevious()) {
            // Take a step back
            String value = listIterator.previous();
            System.out.println("Value:" + value);// -->"Two"
        }

        System.out.println(" ----- ");

        while (listIterator.hasNext()) {
            String value = listIterator.next();
            System.out.println("value:" + value);
        }
    }
}
