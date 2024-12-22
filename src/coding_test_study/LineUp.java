package coding_test_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LineUp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int P = Integer.parseInt(br.readLine());
        for (int i = 0; i < P; i++) {
            String[] input = br.readLine().split(" ");
            int caseNum = Integer.parseInt(input[0]);
            List<Integer> line = new ArrayList<>();
            int step = 0;

            for (int j = 1; j <= 20; j++) {
                int h = Integer.parseInt(input[j]);
                int idx = 0;

                while (idx < line.size() && line.get(idx) < h) {
                    idx++;
                }

                line.add(idx, h);
                step += line.size() - idx - 1;
            }

            sb.append(caseNum).append(" ").append(step).append("\n");
        }
        System.out.println(sb);
    }
}
