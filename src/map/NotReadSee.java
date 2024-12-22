package map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class NotReadSee {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        HashSet<String> notRead = new HashSet<>();

        for (int i = 0; i < N; i++) {
            notRead.add(sc.nextLine());
        }
        ArrayList<String> notReadSee = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            String name = sc.nextLine();
            if (notRead.contains(name)){
                notReadSee.add(name);
            }
        }

        Collections.sort(notReadSee);

        System.out.println(notReadSee.size());
        for (String name :
                notReadSee) {
            System.out.println(name);
        }
    }
}
