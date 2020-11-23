package search;

/**
 * 二分查找
 */
public class ErfenSearch {
    public static void main(String[] args) {
        int[] numbers = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int index = new ErfenSearch().erFen(numbers, 9);
        System.out.println(index);
    }

    private int erFen(int[] numbers, int target) {
        int len = numbers.length;
        int low = 0;
        int hig = numbers.length;
        for(;low <= hig;) {
            int center = (low + hig) / 2;
            if (target == numbers[center]) {
                return center;
            }
            if (target > numbers[center]) {
                low = center;
            }
            if (target < numbers[center]) {
                hig = center;
            }
        }
        return -1;
    }
}
