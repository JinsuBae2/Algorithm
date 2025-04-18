package coding_test_study;

import java.io.*;
import java.util.*;

public class MemorizeEng {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> wordCnt = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() >= M) {
                wordCnt.put(word, wordCnt.getOrDefault(word, 0) + 1);
            }
        }
        List<Map.Entry<String,Integer>> sortedWords = new ArrayList<>(wordCnt.entrySet());
        sortedWords.sort((a, b) -> {
            if (!b.getValue().equals(a.getValue())) {
                return b.getValue() - a.getValue();
            }
            if (b.getKey().length() != a.getKey().length()) {
                return b.getKey().length() - a.getKey().length();
            }
            return a.getKey().compareTo(b.getKey());
        });

        for (Map.Entry<String,Integer> entry:sortedWords) {
            bw.write(entry.getKey() + "\n");
        }

        bw.flush();
    }
}
