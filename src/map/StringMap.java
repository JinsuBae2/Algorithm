package map;

import java.util.HashSet;
import java.util.Scanner;

public class StringMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        HashSet<String> stringHashSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            stringHashSet.add(sc.nextLine());
        }
        int cnt = 0;

        for (int i = 0; i < M; i++) {
            String s = sc.nextLine();
            if (stringHashSet.contains(s)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
