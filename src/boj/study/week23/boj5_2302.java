package boj.study.week23;

import java.io.*;

public class boj5_2302 {
    static int N, M;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        if (N == 1 || N == 2) {
            bw.write(N + "");
            bw.close();
            return;
        }
        dp = new int[N + 1];
        dp[0] = 1;

        dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int vip;
        int beforeVip = 0;
        int answer = 1;
        for (int i = 0; i < M; i++) {
            vip = Integer.parseInt(br.readLine());
            answer *= dp[vip - beforeVip - 1];
            beforeVip = vip;
        }

        if (beforeVip != N) {
            answer *= dp[N - beforeVip];
        }

        bw.write(answer + "");
        bw.close();
    }
}
