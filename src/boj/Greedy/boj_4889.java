package boj.Greedy;

import java.io.*;
import java.util.*;

public class boj_4889 {
    static Queue<Character> q;
    static int count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



        int testCase = 0;
        while (true) {
            String str = br.readLine();
            if (str.startsWith("--")) {
                bw.close();
                return;
            }
            q = new LinkedList<>();
            count = 0;
            testCase++;
            for (char c : str.toCharArray()) {
                if (c == '{') q.add(c);
                else {
                    if (q.isEmpty()) {
                        count++;
                        q.add('{');
                    } else {
                        q.poll();
                    }
                }
            }

            if (!q.isEmpty()) {
                count += q.size() / 2;
            }
            bw.write(testCase + ". " + count + "\n");
        }
    }
}
