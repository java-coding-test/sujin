package boj.study.week24;

import java.io.*;

public class boj_9713 {
    static int T, N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            bw.write(calculate(N) + "\n");
        }

        bw.close();
    }

    public static int calculate(int n) {
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            if (i % 2 != 0) {
                sum += i;
            }
        }
        return sum;
    }
}
