package cumulative_sum;

import java.util.Scanner;

public class IntervalOfSum4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] numbers = new int[N + 1];
        for (int i = 1; i < N+1; i++) {
            numbers[i] = numbers[i-1] + sc.nextInt();
        }
        for (int i = 0; i < M; i++) {
            int k = sc.nextInt();
            int z = sc.nextInt();
            System.out.println(numbers[z] - numbers[k - 1]);
        }
    }
}
