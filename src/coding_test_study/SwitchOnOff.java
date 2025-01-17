package coding_test_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SwitchOnOff {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] switches = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int stdCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < stdCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                for (int j = number; j <= n; j += number) {
                    switches[j] = switches[j] == 1 ? 0 : 1;
                }
            } else if (gender == 2) {
                switches[number] = switches[number] == 1 ? 0 : 1;
                int leftNum = number - 1;
                int rightNum = number + 1;
                while (leftNum >= 1 && rightNum <= n && switches[leftNum] == switches[rightNum]){
                    switches[leftNum] = switches[leftNum] == 1 ? 0 : 1;
                    switches[rightNum] = switches[rightNum] == 1 ? 0 : 1;
                    leftNum--;
                    rightNum++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(switches[i]).append(" ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
