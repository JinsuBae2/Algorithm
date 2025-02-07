package coding_test_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Blog {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] visit = new int[N];

        for (int i = 0; i < N; i++) {
            visit[i] = Integer.parseInt(st.nextToken());
        }

        int currntSum = Arrays.stream(visit, 0, X).sum();
        int cnt = 1;
//        for (int i = 0; i < X; i++) {
//            currntSum += visit[i];
//        }
        int maxVisit = currntSum;
        for (int i = X; i < N; i++) {
            currntSum += visit[i] - visit[i - X];
            if (currntSum > maxVisit) {
                maxVisit = currntSum;
                cnt = 1;
            } else if (currntSum == maxVisit) {
                cnt++;
            }
        }

        if (maxVisit == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxVisit);
            System.out.println(cnt);
        }
    }
}
