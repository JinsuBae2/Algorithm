package sort;

import java.util.Arrays;
import java.util.Scanner;

public class RepresentativeValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = new int[5];
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            num[i] = sc.nextInt();
            sum += num[i];
        }
        Arrays.sort(num);
        System.out.println(sum / num.length);
        System.out.println(num[2]);
    }
}
