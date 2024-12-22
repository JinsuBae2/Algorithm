package map;

import java.util.HashSet;
import java.util.Scanner;

public class NumberCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        HashSet<Integer> cardSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            cardSet.add(sc.nextInt());
        }

        int M = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int num = sc.nextInt();
            if (cardSet.contains(num)) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb.toString().trim());

        sc.close();
    }
}