package order;

import java.util.Arrays;

/**
 * 直接选择排序
 * 循环列表，每次选择最大的排序
 */
public class ZhiJieOrder {

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 8, 7, 3, 2, 5, 6, 4, 9, 0, 8};
        new ZhiJieOrder().zhiJiePaoAsc(numbers);
        System.out.println(Arrays.toString(numbers));
     }
    public void zhiJiePaoAsc(int[] numbers) {
        for (int i = 0; i < numbers.length -1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]){
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }
}
