package coding_test_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CookieMeasurement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char [][] grid = new char[N][N];

        for (int i = 0; i < N; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        int heartRow = 0, heartCol = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == '*' && j > 0 && j < N - 1 && grid[i -1][j] == '*' && grid[i + 1][j] == '*') {
                    heartRow = i;
                    heartCol = j;
                    break;
                }
            }
            if (heartRow != 0) break;
        }

        int leftArm = 0, rightArm = 0, waist = 0, leftLeg = 0, rightLeg = 0;

        for (int i = heartCol - 1; i >= 0; i--) {
            if (grid[heartRow][i] == '*') leftArm++;
            else break;
        }
        for (int i = heartCol + 1; i < N; i++) {
            if (grid[heartRow][i] == '*') rightArm++;
            else break;
        }
        for (int i = heartRow + 1; i < N; i++) {
            if (grid[i][heartCol] == '*') waist++;
            else break;
        }
        for (int i = heartRow + waist + 1; i < N; i++) {
            if (grid[i][heartCol - 1] == '*') leftLeg++;
            else break;
        }
        for (int i = heartRow + waist + 1; i < N; i++) {
            if (grid[i][heartCol + 1] == '*') rightLeg++;
            else break;
        }
        System.out.println((heartRow + 1) + " " + (heartCol + 1));
        System.out.println(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);
    }
}
