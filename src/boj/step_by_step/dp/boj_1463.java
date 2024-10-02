package boj.step_by_step.dp;

import java.io.*;
import java.util.Arrays;

public class boj_1463 {
    static int N;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        dp[N] = 0;
        int[] num = new int[3];
        for (int i = N - 1; i >= 1; i--) {
            Arrays.fill(num, 1000000);
            if (i * 3 <= N) {
                num[0] = dp[i * 3] + 1;
            }
            if (i * 2 <= N) {
                num[1] = dp[i * 2] + 1;
            }
            if (i + 1 <= N) {
                num[2] = dp[i + 1] + 1;
            }
            Arrays.sort(num);
            dp[i] = num[0];
        }
        bw.write(dp[1] + "");
        bw.close();
    }
}
