package cumulative_sum;

import java.util.Scanner;

public class RemainSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }
        int [] count = new int[M];
        long sum = 0;
        long result = 0;

        for (int i = 0; i < N; i++) {
            sum += numbers[i];
            int remainder = (int) (sum % M);

            if (remainder < 0) {
                remainder += M;
            }

            if (remainder == 0) {
                result++;
            }

            result += count[remainder];

            count[remainder]++;
        }
        System.out.println(result);

    }

}
