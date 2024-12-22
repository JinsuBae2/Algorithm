package dp;

import java.util.Scanner;

public class ExcitingFunction {
    static int[][][] dp = new int[21][21][21]; // 메모이제이션을 위한 배열

    public static int w(int a, int b, int c) {
        // 기저 조건: a, b, c 중 하나라도 0 이하이면 1을 반환
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        // 이미 계산된 값이 있으면 그 값을 반환
        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }

        // 이미 메모이제이션 된 값이 있으면 그 값을 반환
        if (dp[a][b][c] != 0) {
            return dp[a][b][c];
        }

        // 조건에 따른 계산 및 메모이제이션
        if (a < b && b < c) {
            dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        } else {
            dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
        }

        return dp[a][b][c];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, w(a, b, c));
        }
    }
}