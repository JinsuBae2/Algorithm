//package map;
//
//import java.util.HashMap;
//import java.util.Scanner;
//
//public class PokemonMaster {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt(), M = sc.nextInt();
//        sc.nextLine(); // 남아 있는 개행 문자 제거
//
//        HashMap<String, String> nameToNumber = new HashMap<>();
//        for (int i = 1; i <= N; i++) {
//            String name = sc.nextLine();
//            String num = String.valueOf(i);
//            nameToNumber.put(name, num);
//            nameToNumber.put(num, name);
//        }
//
//        for (int i = 0; i < M; i++) {
//            System.out.println(nameToNumber.get(sc.nextLine()));
//        }
//
//        sc.close();
//    }
//}

package map;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.HashMap;

public class PokemonMaster {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        HashMap<String, String> nameToNumber = new HashMap<>(N * 2); // 예상 크기 미리 할당
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            String num = String.valueOf(i);
            nameToNumber.put(name, num);
            nameToNumber.put(num, name);
        }

        for (int i = 0; i < M; i++) {
            bw.write(nameToNumber.get(br.readLine()));
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }
}