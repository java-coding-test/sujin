package boj.step_by_step.dp;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] stairs;

    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        stairs = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[N + 1];
        dp[1] = stairs[1];
        if (N >= 2) dp[2] = stairs[1] + stairs[2];
        if (N >= 3) {
            dp[3]  = Math.max(stairs[1] + stairs[3], stairs[2] + stairs[3]);
        }
        for (int i = 4; i <= N; i++) {
            dp[i] = Math.max(dp[i - 3] + stairs[i - 1], dp[i - 2]) + stairs[i];
        }

        bw.write(dp[N] + "");
        bw.close();
    }
}
