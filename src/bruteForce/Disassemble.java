package bruteForce;

import java.util.Scanner;

public class Disassemble {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int min = 1000000;
        
        for (int i = 0; i <= 1000000; i++) {
            int sum = 0;
            String numString = String.valueOf(i);
            for (int j = 0; j < numString.length(); j++) {
                sum += numString.charAt(j) - '0';
            }
            sum += i;
            if (sum == N && sum < min) {
                min = i;
            }
        }

        if (min == 1000000) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }

    }
}
