package dp;

import java.util.Arrays;

// 非递归的方式
public class FeiBoTwo {
    public static void main(String[] args) {
        int n = 5;
//        int f0 = 0;
//        int f1 = 1;
        int f2 = 0;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                nums[i] = 0;
            }else if (i == 1){
                nums[i] = 1;
            }else {
                nums[i] = nums[i -1] + nums[i -2];
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
