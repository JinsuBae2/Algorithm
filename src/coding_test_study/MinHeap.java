package coding_test_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 1927 - 최소 힙
public class MinHeap {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (minHeap.isEmpty()) {
                    System.out.println(0);
                } else {
                    int deleteNum = minHeap.poll();
                    System.out.println(deleteNum);
                }
            } else {
                minHeap.offer(num);
            }
        }
    }
}
