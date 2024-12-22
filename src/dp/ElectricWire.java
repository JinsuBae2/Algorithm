package dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ElectricWire {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] wires = new int[N][2];

        for (int i = 0; i < N; i++) {
            wires[i][0] = sc.nextInt();
            wires[i][1] = sc.nextInt();
        }

        Arrays.sort(wires, Comparator.comparingInt(a -> a[0]));

        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (wires[i][1] > wires[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = Arrays.stream(dp).max().getAsInt();

        System.out.println(N - max);
    }
}