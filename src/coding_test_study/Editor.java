package coding_test_study;

import java.io.*;
import java.util.Stack;

// 1406 - 에디터
public class Editor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int M = Integer.parseInt(br.readLine());

        Stack<String> leftStack = new Stack<>();
        Stack<String> rightStack = new Stack<>();

        String [] arr = str.split("");
        for (String s : arr) {
            leftStack.push(s);
        }
        for (int i = 0; i < M; i++) {
            String command = br.readLine();
            char c = command.charAt(0);

            switch (c) {
                case 'L':
                    if (!leftStack.isEmpty())
                        rightStack.push(leftStack.pop());
                    break;
                case 'D':
                    if (!rightStack.isEmpty())
                        leftStack.push(rightStack.pop());
                    break;
                case 'B' :
                    if (!leftStack.isEmpty())
                        leftStack.pop();
                    break;
                case 'P':
                    char t = command.charAt(2);
                    leftStack.push(String.valueOf(t));
                    break;
                default:
                    break;
            }
        }

        while (!leftStack.isEmpty())
            rightStack.push(leftStack.pop());
        while (!rightStack.isEmpty())
            bw.write(rightStack.pop());

        bw.flush();
        bw.close();

    }
}
