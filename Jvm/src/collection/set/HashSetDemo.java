package collection.set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashSetDemo {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        hashSet.add("a");
        hashSet.add("a");
        hashSet.remove("a");
        hashSet.hashCode();

        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("a", "1");
        hashMap.put("b", "2");
        hashMap.put(null, null);
        hashMap.remove("a");
        hashMap.get("a");
    }
}
