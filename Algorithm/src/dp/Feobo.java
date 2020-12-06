package dp;

import java.util.Arrays;

/**
 * 递归菲波那切数列
 */
public class Feobo {
    public static void main(String[] args) {
        int n = 10;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = getNums(i);
        }
        System.out.println(Arrays.toString(nums));
    }
    public static int getNums(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return getNums(n - 1) + getNums(n -2);
    }
}
