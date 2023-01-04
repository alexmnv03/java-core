package collectionsframework.map.IdentityHashMap;

import java.util.IdentityHashMap;

public class IdentityHashMapExample {
    public static void main(String[] args) {
        String key1 = "Tom";
        String key2 = new String("Tom");

        // key1 == key2 ? false
        System.out.println("key1 == key2 ? " + (key1== key2)); // false

        IdentityHashMap<String, String> map = new IdentityHashMap<String, String>();

        map.put(key1, "Value 1");
        map.put(key2, "Value 2");

        System.out.println("Map Size: " + map.size());

        System.out.println(map);
    }
}
