package str;

public class StringDemo {
    /**
     * 类加载不允许重名
     * @param args
     */
    public static void main(String[] args) {
        // 编译报错
        //String a = "dddd";
        String a = "ddd";
        int hashCode = a.hashCode();
        System.out.println(hashCode);
    }
}
