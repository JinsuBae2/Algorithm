package coding_test_study;

import java.io.*;

public class DigitalTV {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] channels = new String[N];
        int i = 0;
        int j = 0;
        String temp;
        for (int z = 0; z < N; z++) {
            channels[z] = br.readLine();
        }
        while (!channels[0].equals("KBS1")) {
            if (!channels[i].equals("KBS1")){
                bw.write("1");
                i++;
            } else {
                bw.write("4");
                temp = channels[i];
                channels[i] = channels[i-1];
                channels[i-1] = temp;
                i--;
            }

        }
        while (!channels[1].equals("KBS2")) {
            if (!channels[j].equals("KBS2")){
                bw.write("1");
                j++;
            } else {
                bw.write("4");
                temp = channels[j];
                channels[j] = channels[j-1];
                channels[j-1] = temp;
                j--;
            }

        }
        bw.flush();
    }
}
