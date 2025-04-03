package coding_test_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

// 22233 - 가희와 키워드
public class KahiAndKeyword {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> memo = new HashSet<>();
        for (int i = 0; i < N; i++) {
            memo.add(br.readLine());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), ",");
            while (st.hasMoreTokens()) {
                String  keyword = st.nextToken();
                memo.remove(keyword);
            }
            System.out.println(memo.size());
        }
    }
}
