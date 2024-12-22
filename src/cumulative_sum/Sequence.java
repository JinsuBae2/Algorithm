package cumulative_sum;

import java.util.Arrays;
import java.util.Scanner;

public class Sequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] temp = new int[N];
        for (int i = 0; i < N; i++) {
            temp[i] = sc.nextInt();
        }
        int [] dp = new int[N - K + 1];
        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += temp[i];
        }
        dp[0] = sum;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i-1] + temp[i + K - 1] - temp[i-1];
        }
        int max = Arrays.stream(dp).max().getAsInt();

        System.out.println(max);
    }
}
