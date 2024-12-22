package dp;

import java.util.Scanner;

public class Fibonacci1 {
    static int recursiveCnt = 0;
    static int dpCnt = 0;

    public static int fib(int n) {
        if (n == 1 || n == 2) {
            recursiveCnt++;
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static int fibonacciDP(int n) {
        int[] dp = new int[n + 1];
        dp[1] = dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dpCnt++;
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fib(n);
        fibonacciDP(n);

        System.out.println(recursiveCnt + " " + dpCnt);
    }
}