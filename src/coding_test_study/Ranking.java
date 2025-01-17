package coding_test_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Ranking  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        List<Integer> scores = new ArrayList<>();
        if (N > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                scores.add(Integer.parseInt(st.nextToken()));
            }
        }

        scores.add(newScore);
        scores.sort(Collections.reverseOrder());

        int rank = 1;
        for (int i = 0; i < scores.size(); i++) {
            if (i > 0 && scores.get(i).equals(scores.get(i - 1))) continue;
            if (scores.get(i) == newScore) {
                rank = i + 1;
                break;
            }
        }

        if (scores.size() > P) {
            int excludedScore = scores.get(P);
            if (excludedScore == newScore) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(rank);
    }
}
