package order;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class MaoPaoSort {
    public static void main(String[] args) {
        int[] numbers = new int[] {1, 8, 7, 3, 2, 5, 6, 4, 9, 0};
        new MaoPaoSort().maoPaoAsc(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    public void maoPaoAsc(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - 1 - i; j++) {
                if (numbers[j] < numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }
}
