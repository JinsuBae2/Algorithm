package coding_test_study;

import java.util.Scanner;

public class ZOAC4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();

        int cnt = 0;

        for (int i = 0; i < h; i+=n+1) {
            for (int j = 0; j < w; j+=m+1) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
