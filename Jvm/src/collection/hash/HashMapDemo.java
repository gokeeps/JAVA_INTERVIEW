package collection.hash;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>(1024);
        map.put("n1", 1);
        map.put("n1", 2);
        map.put("n3", 3);
        System.out.println(map.get("n1"));
        System.out.println(map);
        System.out.println(map.size());

        System.out.println("-----------------");
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            System.out.println(stringIntegerEntry.getKey());
            System.out.println(stringIntegerEntry.getValue());
        }
    }
}
