package coding_test_study;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 3758
public class KCPC {
    static int T, n, k, t, m;
    static class Team {
        int teamId;
        int [] scoreList;
        int cnt;
        int lastSubmit;
        int totalScore;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); //팀의 개수
            k = Integer.parseInt(st.nextToken()); //문제 개수
            t = Integer.parseInt(st.nextToken()); //나의 팀 ID
            m = Integer.parseInt(st.nextToken()); //로그 개수

            Team[] teams = new Team[n];
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int teamId = Integer.parseInt(st.nextToken());
                int probNum = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                if (teams[teamId - 1] == null) {
                    teams[teamId - 1] = new Team();
                    teams[teamId - 1].teamId = teamId;
                    teams[teamId - 1].scoreList = new int[k + 1];
                }

                teams[teamId - 1].scoreList[probNum] = Math.max(score, teams[teamId - 1].scoreList[probNum]);
                teams[teamId - 1].cnt++;
                teams[teamId - 1].lastSubmit = j;
            }
            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int l = 0; l <= k; l++) {
                    sum += teams[j].scoreList[l];
                }
                teams[j].totalScore = sum;
            }
            Arrays.sort(teams, (o1, o2) -> {
                if (o1.totalScore == o2.totalScore) {
                    if (o1.cnt == o2.cnt) {
                        return o1.lastSubmit - o2.lastSubmit;
                    }
                    return o1.cnt - o2.cnt;
                }
                return o2.totalScore - o1.totalScore;
            });
            for (int j = 0; j < n; j++) {
                if (teams[j].teamId == t)
                    bw.append(String.valueOf(j + 1)).append("\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
