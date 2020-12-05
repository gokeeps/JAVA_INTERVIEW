package bytes;

public class Demo {
    public static void main(String[] args) {
        int a = 4 & 6;
        System.out.println(a);
        System.out.println(~4);
        System.out.println(3^4);
        System.out.println(3>>>32);
        System.out.println(3>>0);
        System.out.println(3>>-1);

        System.out.println(Integer.MAX_VALUE);
        System.out.println(2147483647 + 9999);
        System.out.println((2147483647&9999)+((2147483647^9999)>>1));

        System.out.println(6&99);

        char[] ss = new char[]{};
        System.out.println(ss.length);
    }
}
