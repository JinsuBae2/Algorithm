package coding_test_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SetProb {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        boolean[] set = new boolean[21];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String calc = st.nextToken();

            switch (calc) {
                case "add" -> {
                    int x = Integer.parseInt(st.nextToken());
                    set[x] = true;
                }
                case "remove" -> {
                    int x = Integer.parseInt(st.nextToken());
                    set[x] = false;
                }
                case "check" -> {
                    int x = Integer.parseInt(st.nextToken());
                    sb.append(set[x] ? "1\n" : "0\n");
                }
                case "toggle" -> {
                    int x = Integer.parseInt(st.nextToken());
                    set[x] = !set[x];
                }
                case "all" -> Arrays.fill(set, true);
                case "empty" -> Arrays.fill(set, false);
            }
        }
        System.out.println(sb);
    }
}
