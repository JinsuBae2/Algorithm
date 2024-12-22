package coding_test_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PasswordChecker{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String password = br.readLine();
            if (password.equals("end")) break;

            if (isAcceptable(password)){
                System.out.printf("<%s> is acceptable.\n", password);
            } else {
                System.out.printf("<%s> is not acceptable.\n", password);
            }
        }
    }

    // 비밀번호 조건 테스트
    private static boolean isAcceptable(String password) {
        return hasVowel(password) && hasThreeStraight(password) && hasSameRepeat(password);
    }

    // 1. 모음이 하나라도 포함되어 있는지 확인
    private static boolean hasVowel(String password) {
        return password.matches(".*[aeiou].*");
    }


    // 2. 모음 3개 또는 자음 3개가 연속으로 오는지 확인
    private static boolean hasThreeStraight(String password) {
        char[] chars = password.toCharArray();
        for (int i = 0; i < chars.length - 2; i++) {
            boolean firstIsVowel = isVowel(chars[i]);
            boolean secondIsVowel = isVowel(chars[i + 1]);
            boolean thirdIsVowel = isVowel(chars[i + 2]);
            if (firstIsVowel == secondIsVowel && secondIsVowel == thirdIsVowel){
                return false;
            }
        }
        return true;
    }



    // 3. 연속된 같은 문자가 있는지 확인 (단, ee와 oo는 허용)
    private static boolean hasSameRepeat(String password) {
        for (int i = 1; i < password.length(); i++) {
            char prev = password.charAt(i - 1);
            char curr = password.charAt(i);
            if (prev == curr && !(prev == 'e' || prev == 'o') ) {
                return false;
            }
        }
        return true;
    }

    // 모음인지 확인
    private static boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}
