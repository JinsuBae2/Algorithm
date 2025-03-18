package coding_test_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2607
public class SimilarWord {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 비교 문자열 개수
        int numCnt = Integer.parseInt(br.readLine());

        // 비교할 첫번째 단어
        String firstWord = br.readLine();
        int result = 0;

        // 첫번째 단어를 뺀 나머지 단어들 만큼 반복
        for (int i = 0; i < numCnt - 1; i++) {
            String word = br.readLine();
            int cnt = 0;
            int[] alphabet = new int[26];

            for (int j = 0; j < firstWord.length(); j++) {
                alphabet[firstWord.charAt(j) - 'A']++;
            }

            for (int j = 0; j < word.length(); j++) {
                if (alphabet[word.charAt(j) - 'A'] > 0) {
                    cnt++;
                    alphabet[word.charAt(j) - 'A']--;
                }
            }

            // 문자열의 길이가 같거나 한 글자만 바뀐 경우
            if (firstWord.length() == word.length() && (firstWord.length() == cnt || firstWord.length() - 1 == cnt)) {
                result++;
            }
            // 비교 문자열 (word)의 길이가 더 긴 경우
            else if (firstWord.length() + 1 == word.length() && word.length() - 1 == cnt) {
                result++;
            }
            // 비교 문자열 (word)의 길이가 더 짧은 경우
            else if (firstWord.length() - 1 == word.length() && word.length() == cnt) {
                result++;
            }

        }
        System.out.println(result);
    }
}
