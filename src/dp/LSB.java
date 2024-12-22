package dp;

import java.util.Scanner;

public class LSB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] dp_inc = new int[N];
        int[] dp_dec = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
            dp_dec[i] = 1;
            dp_inc[i] = 1;
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    dp_inc[i] = Math.max(dp_inc[i], dp_inc[j]+1);
                }
            }
        }
        for (int i = N - 1; i >= 0; i--) {
            for (int j = i + 1; j < N; j++) {
                if (A[i] > A[j]) {
                    dp_dec[i] = Math.max(dp_dec[i], dp_dec[j] + 1);
                }
            }
        }
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            dp[i] = dp_dec[i] + dp_inc[i] - 1;
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
