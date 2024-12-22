package bruteForce;

import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] cardSet = new int[N];
        for (int i = 0; i < N; i++) {
            cardSet[i] = sc.nextInt();
        }
        int max = 0;

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int temp = cardSet[i] + cardSet[j] + cardSet[k];
                    if (temp > max && temp <= M){
                        max = temp;
                    }
                }
            }
        }

        System.out.println(max);
    }
}
