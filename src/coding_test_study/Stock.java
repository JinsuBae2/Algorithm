package coding_test_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 11501 - 주식
public class Stock {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] chart = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                chart[j] = Integer.parseInt(st.nextToken());
            }

            int maxValue = chart[N - 1];
            long price = 0;
            for (int j = N - 2; j >= 0; j--) {
                if (maxValue < chart[j]) {
                    maxValue = chart[j];
                } else if (maxValue >= chart[j]){
                    price += (maxValue - chart[j]);
                }
            }
            System.out.println(price);
        }
    }
}
