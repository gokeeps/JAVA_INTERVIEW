package simple;

import java.util.HashSet;
import java.util.Set;

public class Out {
    public static void main(String[] args) {
        System.out.println("Hello World");
        String s = "leetcode";
        char[] a = "".toCharArray();
        if (a.length > 0)
        System.out.println(s.indexOf("b"));
        System.out.println(isUnique(s));
    }

    public static boolean isUnique(String astr) {
        Set<String> chars = new HashSet();
        for (char c : astr.toCharArray()) {
            if (chars.contains(String.valueOf(c))) {
                return true;
            }else {
                chars.add(String.valueOf(c));
            }
        }
        return false;
    }
}
