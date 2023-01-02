package utilconcurrent.collections.ConcurrentHashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * При использование класса ConcurrentHashMap цикл перебора с использованием итератора завершился
 * нормально; в консоль попал также новый объект с ключом "2", добавленный в набор во время
 * итерации. А вот при использовании класса HashMap цикл был прерван вызовом исключения
 * ConcurrentModificationException, как и ожидалось. Место ошибки : String key = it.next();.  Т.е
 * . итератор вызывает исключение при обращении к следующему объекту, если набор изменился.
 */
public class ConcurrentHashMapExample {

    public static void main(String[] args)
    {
        Map<String, String> map;

        System.out.println("ConcurrentHashMap");
        map = createMap(true);
        addValue (true, map);

        System.out.println("\n\nHashMap");
        map = createMap(false);
        addValue (false, map);

    }

    private static void addValue(boolean concurrent, Map<String, String> map)
    {
        System.out.println("  before iterator : " + map);
        Iterator<String> it = map.keySet().iterator();

        System.out.print("  cycle : ");
        while(it.hasNext()){
            String key = it.next();
            if (key.equals("2")) {
                map.put(key + "new", "222");
            } else
                System.out.print("  " + key + "="
                        + map.get(key));
        }
        System.out.println();
        System.out.println("  after iterator : " + map);
    }

    private static Map<String, String> createMap(boolean concurrent)
    {
        Map<String, String> map;
        if (concurrent)
            map = new ConcurrentHashMap<String, String>();
        else
            map = new HashMap<String, String> ();
        map.put("1", "1");
        map.put("2", "1");
        map.put("3", "1");
        map.put("4", "1");
        map.put("5", "1");
        map.put("6", "1");
        return map;
    }

}
