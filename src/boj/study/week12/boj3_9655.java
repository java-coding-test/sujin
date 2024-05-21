package boj.study.week12;

import java.io.*;

public class boj3_9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String answer = (N % 2 == 0) ? "CY" : "SK";
        bw.write(answer);
        bw.close();
    }
}
