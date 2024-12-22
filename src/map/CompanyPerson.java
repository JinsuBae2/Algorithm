package map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class CompanyPerson {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<String> person =  new HashSet<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            if (sc.next().equals("enter")) {
                person.add(name);
            } else {
                person.remove(name);
            }
        }
        ArrayList<String> sortedList = new ArrayList<>(person);
        sortedList.sort(Collections.reverseOrder());

        for (String name : sortedList) {
            System.out.println(name);
        }
    }
}
