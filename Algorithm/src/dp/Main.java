package dp;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = scanner.nextInt();
            if (n == 0) {
                break;
            }
            System.out.println(getWay(n));
        }
    }

    public static int getWay (int n) {
        if (n <= 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        int p = n / 3;
        int s = n % 3;
        return p + getWay(p + s);
    }
}