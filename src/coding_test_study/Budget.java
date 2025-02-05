package coding_test_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Budget {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] listBudget = new long[N];
        long M = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            listBudget[i] = Integer.parseInt(st.nextToken());
        }

        long result = maxBudget(M, listBudget);
        System.out.println(result);
    }

    private static long maxBudget(long m, long[] listBudget) {
        long left = 0;
        long right = Arrays.stream(listBudget).max().getAsLong();
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long total = 0;

            for (long budget :
                    listBudget) {
                total += Math.min(budget, mid);
            }

            if (total <= m) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
}
