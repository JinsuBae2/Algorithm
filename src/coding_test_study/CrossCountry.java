package coding_test_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CrossCountry {
    static class Team {
        int teamNum;
        int totalScore;
        int fifthScore;

        public Team(int teamNum, int totalScore, int fifthScore) {
            this.teamNum = teamNum;
            this.totalScore = totalScore;
            this.fifthScore = fifthScore;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] teamOrder = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            Map<Integer, List<Integer>> teamScores = new HashMap<>();
            for (int i = 0; i < N; i++) {
                int team = teamOrder[i];
                teamScores.putIfAbsent(team, new ArrayList<>());
                teamScores.get(team).add(i + 1);
            }

            teamScores.entrySet().removeIf(entry -> entry.getValue().size() < 6);

            Map<Integer, List<Integer>> validTeamScores = new HashMap<>();
            int score = 1;
            for (int team : teamOrder) {
                if (teamScores.containsKey(team)) {
                    validTeamScores.putIfAbsent(team, new ArrayList<>());
                    validTeamScores.get(team).add(score++);
                }
            }

            List<Team> rankedTeams = new ArrayList<>();
            for (Map.Entry<Integer, List<Integer>> entry : validTeamScores.entrySet()) {
                List<Integer> scores = entry.getValue();
                Collections.sort(scores);
                int totalScore = scores.get(0) + scores.get(1) + scores.get(2) + scores.get(3);
                int fifthScore = scores.get(4);
                rankedTeams.add(new Team(entry.getKey(), totalScore, fifthScore));
            }

            rankedTeams.sort((t1, t2) -> {
                if (t1.totalScore != t2.totalScore) {
                    return t1.totalScore - t2.totalScore;
                }
                return t1.fifthScore - t2.fifthScore;
            });

            sb.append(rankedTeams.get(0).teamNum).append("\n");
        }

        System.out.println(sb);
    }
}