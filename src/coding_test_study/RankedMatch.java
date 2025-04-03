package coding_test_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 20006 - 랭킹전 대기열
public class RankedMatch {
    static class Rooms {
        int level;
        int cnt;
        ArrayList<Player> players = new ArrayList<>();

        Rooms (int level, Player player) {
            this.level = level;
            this.players.add(player);
            this.cnt = 1;
        }
    }
    static class Player implements Comparable<Player> {
        int level;
        String nickname;

        public Player(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }

        @Override
        public int compareTo(Player o) {
            return (this.nickname).compareTo(o.nickname);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken()); //플레이어의 수
        int m = Integer.parseInt(st.nextToken()); //방의 정원
        Deque<Rooms> rooms = new ArrayDeque<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();

            boolean check = false;
            for (Rooms room : rooms) {
                if (Math.abs(level - room.level) <= 10 && room.cnt < m) {
                    room.players.add(new Player(level,nickname));
                    room.cnt += 1;
                    check = true;
                    break;
                }
            }
            if (!check) {
                rooms.addLast(new Rooms(level, new Player(level, nickname)));
            }
        }

        for (Rooms room : rooms) {
            if (room.cnt == m) {
                System.out.println("Started!");
            }
            if (room.cnt < m) {
                System.out.println("Waiting!");
            }
            Collections.sort(room.players);
            for (int i = 0; i < room.players.size(); i++) {
                System.out.println(room.players.get(i).level + " " + room.players.get(i).nickname);
            }
        }
    }
}
