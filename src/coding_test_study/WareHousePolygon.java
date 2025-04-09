package coding_test_study;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2304 - 창고 다각형
public class WareHousePolygon {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        // 배열 생성 및 값 넣기
        int [][] coord = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            coord[i][0] = Integer.parseInt(st.nextToken());
            coord[i][1] = Integer.parseInt(st.nextToken());
        }

        // 위치 순으로 정렬
        Arrays.sort(coord, (o1, o2) -> o1[0] - o2[0]);

        int area = 0;
        for (int i = 0; i < N;) {
            int j = i + 1;
            int max = j;
            while (j < N && coord[i][1] > coord[j][1]) {
                if (coord[max][1] < coord[j++][1]) max = j - 1;
            }

            if (j >= N) {
                area += coord[i][1];
                if (max < N) area += coord[max][1] * (coord[max][0] - coord[i][0] - 1);
                i = max;
            } else {
                area += coord[i][1] * (coord[j][0] - coord[i][0]);
                i = j;
            }
        }
        System.out.println(area);
    }
}
