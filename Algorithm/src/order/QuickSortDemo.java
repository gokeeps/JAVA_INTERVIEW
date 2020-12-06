package order;

import java.util.Arrays;

public class QuickSortDemo {
    public static void main(String[] args) {
        int[] numbers = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1};
        quickSort(numbers, 0, numbers.length -1);
        System.out.println(Arrays.toString(numbers));
    }

    public static void quickSort(int[] numbers, int left, int right) {
        int l = left;
        int r = right;
        if (l >= right) {
            return;
        }
        int base = numbers[l];
        while (l < r) {
            while (l < r && numbers[r] >= base) {
                r --;
            }
            if (numbers[r] <= base) {
                swap(numbers, r, l);
            }
            while (l < r && numbers[l] <= base) {
                l ++;
            }
            if (numbers[r] >= base) {
                swap(numbers, l, r);
            }
        }
        System.out.println(Arrays.toString(numbers));
        System.out.println("left位置: " + l + " 值: " + numbers[l]);
        quickSort(numbers, left, l - 1);
        quickSort(numbers, l + 1, right);

    }

    public static void swap(int[] number, int a, int b) {
        int tmp = number[a];
        number[a] = number[b];
        number[b] = tmp;
    }
}
