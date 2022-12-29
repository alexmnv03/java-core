package collectionsframework.map.HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class MapIteratorMetods {

    public static void main(String[] args)
    {
        HashMap<String,String> hm = new HashMap<>();

        hm.put("Cricket", "Sachin");
        hm.put("Football", "Zidane");
        hm.put("Tennis", "Federer");

        // 1 Iterate through HashMap
        Iterator<Map.Entry<String, String>> entrySet = hm.entrySet().iterator();
        while (entrySet.hasNext())
        {
            Map.Entry<String, String> entry = entrySet.next();
            System.out.println("Key : "+entry.getKey()+"   Value : "+entry.getValue());
        }
        //2 foreach
        for (Map.Entry<String, String> pair : hm.entrySet()) {
            System.out.println("Key : "+ pair.getKey()+"   Value : "+ pair.getValue());
        }

        //3 foreach  KeySet
        Set<String> keySet = hm.keySet();
        for(String key : keySet)
        {
            System.out.println("Key : "+key+"   Value : "+hm.get(key));
        }

        // 4 Lambda Expressions
        hm.forEach((k,v) -> {System.out.println("Key : "+k+"   Value : "+v);});
        //
        hm.entrySet().forEach((entry) ->
        {System.out.println("Key : "+entry.getKey()+"   Value : "+entry.getValue());});

        // 5 Stream API
        hm.entrySet().stream().forEach
                (entry-> System.out.println("Key : "+entry.getKey()+"   Value : "+entry.getValue()));

        // 6 Using Stream of
        Stream.of(hm.entrySet())
                .forEach((entry) ->{System.out.println(entry);});

    }


}
