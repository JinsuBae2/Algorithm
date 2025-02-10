package coding_test_study;

import java.util.Scanner;

public class WriteANumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int pointer = 0;
        int base = 0;

        while (base++ <= 30000) {
            String tmp = String.valueOf(base);
            for (int i = 0; i < tmp.length(); i++) {
                if (input.charAt(pointer) == tmp.charAt(i)) {
                    pointer++;
                }
                if (pointer == input.length()) {
                    System.out.println(base);
                    return;
                }
            }
        }
    }
}

