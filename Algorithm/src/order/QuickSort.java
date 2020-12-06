package order;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] numbers = new int[] {6, 8, 7, 3, 2, 5, 1, 4, 9, 0};
        quickSort(numbers, 0, numbers.length -1);
    }

    public static void quickSort(int[] numbers, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left;
        int r = right;
        int base = numbers[left];
        while (l < r) {
            // 两个游标不能相交
            while (numbers[r] >= base && r > l) {
                r --;
            }
            swap(numbers, r, l);
            while (numbers[l] <= base && l < r) {
                l ++;
            }
            swap(numbers, r, l);
        }
        System.out.println(Arrays.toString(numbers));
        quickSort(numbers, left, l - 1);
        quickSort(numbers, l + 1, right);
    }

    private static void swap(int[] numbers, int i, int j) {
        int tmp = numbers[j];
        numbers[j] = numbers[i];
        numbers[i] = tmp;
    }
}
