package bruteForce;

import java.util.Scanner;

public class ChessBoard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        sc.nextLine();
        char[][] board = new char[M][N];

        for (int i = 0; i < M; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int minRepaint = Integer.MAX_VALUE;

        for (int x = 0; x <= M - 8; x++) {
            for (int y = 0; y <= N - 8; y++) {
                int repaintW = 0;
                int repaintB = 0;

                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if ((i + j) % 2 == 0) {
                            if (board[x + i][y + j] != 'W') repaintW++;
                            if (board[x + i][y + j] != 'B') repaintB++;
                        } else {
                            if (board[x + i][y + j] != 'B') repaintW++;
                            if (board[x + i][y + j] != 'W') repaintB++;
                        }
                    }
                }

                int currentMin = Math.min(repaintW, repaintB);
                minRepaint = Math.min(minRepaint, currentMin);
            }
        }

        System.out.println(minRepaint);
    }
}
