package collectionsframework.collections.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorExample {
    public static void main(String[] args) {
        // List is a subinterface of Collection.
        List<String> flowers = new ArrayList<String>();

        flowers.add("Tulip");
        flowers.add("Daffodil");
        flowers.add("Poppy");
        flowers.add("Sunflower");
        flowers.add("Bluebell");

        Iterator<String> iterator = flowers.iterator();

        while(iterator.hasNext()) {
            String flower = iterator.next();
            System.out.println(flower);
        }
    }
}
