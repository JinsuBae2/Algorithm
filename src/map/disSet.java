package map;

import java.util.HashSet;
import java.util.Scanner;

public class disSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cntA = sc.nextInt();
        int cntB = sc.nextInt();

        HashSet<Integer> A = new HashSet<>();
        HashSet<Integer> B = new HashSet<>();


        for (int i = 0; i < cntA; i++) {
            A.add(sc.nextInt());
        }
        for (int i = 0; i < cntB; i++) {
            B.add(sc.nextInt());
        }

        HashSet<Integer> intersection = new HashSet<>(A);
        intersection.retainAll(B);

        int diffSize = (A.size() + B.size() - 2 * intersection.size());
        System.out.println(diffSize);

        sc.close();
    }
}
