package order;

import java.util.Arrays;
import java.util.Hashtable;

public class QuickSort {
    public static void main(String[] args) {
        int[] numbers = new int[] {6, 8, 7, 3, 2, 5, 1, 4, 9, 0};
        new QuickSort().quickSort(numbers, 0, numbers.length - 1);
        System.out.println(Arrays.toString(numbers));
    }

    public void quickSort(int[] numbers, int left, int right) {
        int i = left;
        int j = right;
        int centerIndex = (left + right) / 2;
        if (left >= right) {
            return;
        }
        while (i < j) {
            if (i == centerIndex || j == centerIndex) {
                break;
            }
            if (numbers[i] < numbers[centerIndex] ) {
                i++;
                continue;
            }
            if (numbers[j] > numbers[centerIndex]) {
                j--;
                continue;
            }
            int temp =numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
            i++;
            j--;
        }

//        int base = numbers[left];
//        int baseIndex = left;
//
//        while (left < right) {
//            while (base >= numbers[right] && left < right) {
//                right --;
//            }
//            while (base <= numbers[left] && left < right) {
//                left ++;
//            }
//            if (left == right) {
//                int temp = numbers[left];
//                numbers[left] = numbers[right];
//                numbers[right] = temp;
//                break;
//            }
//        }
//        numbers[left] = base;
//        numbers[baseIndex] = numbers[left];
//        quickSort(numbers, baseIndex, left);

    }
}
