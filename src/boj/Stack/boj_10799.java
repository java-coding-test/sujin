package boj.Stack;

import java.util.*;
import java.io.*;

public class boj_10799 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Character> stack = new ArrayDeque<>();

        int answer = 0;

        String str = br.readLine().trim();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                stack.addLast(c);
            } else {
                stack.pollLast();
                if (str.charAt(i - 1) == '(') {
                    answer += stack.size();
                } else {
                    answer++;
                }
            }
        }
        bw.write(answer + "\n");
        bw.close();

    }
}
