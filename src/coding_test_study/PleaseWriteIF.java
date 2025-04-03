package coding_test_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 19637 - IF문 좀 대신 써줘
public class PleaseWriteIF {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String [] named = new String[N];
        int [] power = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            named[i] = st.nextToken();
            power[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(br.readLine());
            int start = 0;
            int last = N-1;
            while (start <= last) {
                int mid = (start + last) / 2;
                if (power[mid] < num) {
                    start = mid + 1;
                } else {
                    last = mid - 1;
                }
            }
            System.out.println(named[start]);
        }

    }
}
