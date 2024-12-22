package cumulative_sum;

import java.util.Scanner;

public class HumanComputerInteraction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        int q = sc.nextInt();

        int[][] prefix = new int[26][S.length() + 1];

        for (int i = 0; i < 26; i++) {
            for (int j = 1; j <= S.length(); j++) {
                prefix[i][j] = prefix[i][j-1] + (S.charAt(j-1) == i + 'a' ? 1 : 0);
            }
        }

        for (int i = 0; i < q; i++) {
            char a = sc.next().charAt(0);
            int l = sc.nextInt();
            int r = sc.nextInt();

            System.out.println(prefix[a - 'a'][r + 1] - prefix[a - 'a'][l]);
        }
    }
}