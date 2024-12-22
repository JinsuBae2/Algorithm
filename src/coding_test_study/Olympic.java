package coding_test_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Olympic {
    public static class Contry {
        int id;
        int gold;
        int silver;
        int bronze;

        public Contry(int id, int gold, int silver, int bronze) {
            this.id = id;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Contry> contries = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            contries.add(new Contry(id, gold, silver, bronze));
        }

        contries.sort((a, b) -> {
            if (b.gold != a.gold) return b.gold - a.gold;
            if (b.silver != a.silver) return b.silver - a.silver;
            return b.bronze - a.bronze;
        });

        int rank = 1;
        for (int i = 0; i < contries.size(); i++) {
            if (i > 0 && !isSameRank(contries.get(i), contries.get(i - 1))) {
                rank = i + 1;
            }
            if (contries.get(i).id == K) {
                System.out.println(rank);
                break;
            }
        }
    }

    private static boolean isSameRank(Contry a, Contry b) {
        return a.gold == b.gold && a.silver == b.silver && a.bronze == b.bronze;
    }
}
