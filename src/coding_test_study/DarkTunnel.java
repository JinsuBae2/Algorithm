package coding_test_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DarkTunnel {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] lamps = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int left = 1, right = N, result = N;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canLightUp(N, lamps, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(result);


    }

    private static boolean canLightUp(int n,int[] lamps, int height) {
        int lastCovered = 0;

        for (int lamp :
                lamps) {
            if (lamp - height > lastCovered) {
                return false;
            }
            lastCovered = lamp + height;
        }
        return lastCovered >= n;
    }
}


