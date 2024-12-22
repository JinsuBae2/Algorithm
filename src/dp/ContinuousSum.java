package dp;

import java.util.Arrays;
import java.util.Scanner;

public class ContinuousSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];

        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        int[] dp = new int[n];

        dp[0] = num[0];
        int max = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1] + num[i], num[i]);
            max = Math.max(dp[i], max);
        }
        System.out.println(max);

    }
}
