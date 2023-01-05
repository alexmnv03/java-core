package collectionsframework.map.HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Используем map для решения задачи:
 * необходимо определить являются ли строки изоморфными.
 * Строки s и t называются изоморфными, если все вхождения каждого символа строки s можно
 * последовательно заменить другим символом и получить строку t.
 * Порядок символов при этом должен сохраняться, а замена — быть уникальной.
 */
public class Isomorphic {

    public static void main(String[] args) {
        // String strFirst = "ACABMKM";
        // String strSecond = "XCXYDWD";
        String strFirst = "ACABMKY";
        String strSecond = "XCXYDWD";

        if (isIsomorphic(strFirst, strSecond)) {
            System.out.println(strFirst + " and " + strSecond + " are Isomorphic");
        }
        else {
            System.out.println(strFirst + " and " + strSecond + " are not Isomorphic");
        }
    }

    // Определить, являются ли строки 'strFirst' и 'strSecond' изоморфными или нет
    public static boolean isIsomorphic(String strFirst, String strSecond)
    {
        // если хотя бы одна из них равна null, они не могут быть изоморфны
        if (strFirst == null || strSecond == null) {
            return false;
        }
        // если строки имеют разную длину, они не могут быть изоморфны
        if (strFirst.length() != strSecond.length()) {
            return false;
        }
        // используем map для хранения сопоставления символов строки strFirst со строкой strSecond
        Map<Character, Character> map = new HashMap<>();
        // используем set для хранения множества уже сопоставленных символов
        for (int i = 0; i < strFirst.length(); i++)
        {
            char x = strFirst.charAt(i);
            char y = strSecond.charAt(i);
            // если 'x' был уже сопоставлен с другим символом
            if (map.containsKey(x))
            {
                // вернуть false, если символ `x` уже был сопоставлен с дургим символом в strSecond
                if (map.get(x) != y) {
                    return false;
                }
            }
            // если 'x' еще не сопоставлен с другим символом
            else {
                // вернуть false, если 'y' уже сопоставлен с каким-то другим символом в strFirst
                if (map.containsValue(y)) {
                    return false;
                }
                // сопоставляем 'x' с 'y'
                map.put(x, y);
            }
        }
        return true;
    }

}
