package greedy;

import java.util.Scanner;

public class Coin0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int [] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }
        int i = N-1;
        int temp = K;
        int coin = 0;
        while (temp > 0 && i >= 0) {
            if (coins[i] <= temp) {
                coin += temp / coins[i];
                temp = temp % coins[i];
            }
            i--;
        }
        System.out.println(coin);
    }
}
