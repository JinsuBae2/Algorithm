package coding_test_study;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class NstBigNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Long> pq = new PriorityQueue<>();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                long num = Long.parseLong(st.nextToken());
                pq.offer(num);
                if (pq.size() > N) {
                    pq.poll();
                }
            }
        }
        System.out.println(pq.peek());
    }

}
