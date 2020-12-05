package bignum;

/**
 * 大数问题求解
 */
public class Demo {


    public static void main(String[] args) {
        int a = Integer.MAX_VALUE;
        int b = 100;
        char[] as = String.valueOf(a).toCharArray();
        char[] bs = String.valueOf(b).toCharArray();
        String res = sum(as, bs);
        System.out.println(a);
        System.out.println(res);
    }

    private static String sum(char[] as, char[] bs) {
        int carry = 0;
        int i = as.length - 1;
        int j = bs.length - 1;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int a = i < 0 ? 0 : Integer.parseInt(String.valueOf(as[i]));
            int b = j < 0 ? 0 : Integer.parseInt(String.valueOf(bs[j]));
            int sum = a + b + carry;
            carry = sum / 10;
            res.insert(0, sum % 10);
            i --;
            j --;
        }
        return res.toString();
    }
}
