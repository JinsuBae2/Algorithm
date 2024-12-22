package sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CoordinateCompression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] original = new int[N];
        int[] sorted = new int[N];

        for (int i = 0; i < N; i++) {
            original[i] = sc.nextInt();
            sorted[i] = original[i];
        }

        Arrays.sort(sorted);

        HashMap<Integer, Integer> compressionMap = new HashMap<>();
        int rank = 0;

        for (int value : sorted) {
            if (!compressionMap.containsKey(value)) {
                compressionMap.put(value, rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(compressionMap.get(original[i])).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}