package coding_test_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class ImsWithGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String G = st.nextToken();

        Set<String> players = new HashSet<>();

        for (int i = 0; i < N; i++) {
            players.add(br.readLine());
        }

        int groupSize = switch (G) {
            case "Y" -> 2;
            case "F" -> 3;
            case "O" -> 4;
            default -> 0;
        };

        int maxGames = players.size() / (groupSize - 1);
        System.out.println(maxGames);
    }
}
