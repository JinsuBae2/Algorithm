package dp;

import java.util.Scanner;

public class LIS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
            dp[i] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }

        System.out.println(max);
    }
}
