package cumulative_sum;

import java.util.Scanner;

public class ChessBoard2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();

        char[][] board = new char[N + 1][M + 1];
        int[][] wStart = new int[N + 1][M + 1];
        int[][] bStart = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String line = sc.nextLine();
            for (int j = 1; j <= M; j++) {
                board[i][j] = line.charAt(j - 1);

                if ((i + j) % 2 == 0) {
                    if (board[i][j] != 'W') wStart[i][j] = 1;
                    if (board[i][j] != 'B') bStart[i][j] = 1;
                } else {
                    if (board[i][j] != 'B') wStart[i][j] = 1;
                    if (board[i][j] != 'W') bStart[i][j] = 1;
                }

                wStart[i][j] += wStart[i - 1][j] + wStart[i][j - 1] - wStart[i - 1][j - 1];
                bStart[i][j] += bStart[i - 1][j] + bStart[i][j - 1] - bStart[i - 1][j - 1];
            }
        }

        int minRepaint = Integer.MAX_VALUE;

        for (int i = K; i <= N; i++) {
            for (int j = K; j <= M; j++) {
                int wCost = wStart[i][j] - wStart[i - K][j] - wStart[i][j - K] + wStart[i - K][j - K];
                int bCost = bStart[i][j] - bStart[i - K][j] - bStart[i][j - K] + bStart[i - K][j - K];
                minRepaint = Math.min(minRepaint, Math.min(wCost, bCost));
            }
        }

        System.out.println(minRepaint);
    }
}
