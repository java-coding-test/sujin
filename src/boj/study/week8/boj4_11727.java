package boj.study.week8;

import java.io.*;

public class boj4_11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] DP = new int[N + 1];

        DP[0] = 1;
        DP[1] = 1;

        // 점화식 찾기
        // DP[n] = DP[n - 1] + 2 * DP[n - 2]

        for (int i = 2; i <= N; i++) {
            DP[i] = (DP[i - 1] + 2 * DP[i - 2]) % 10007;
        }
        System.out.println(DP[N]);
    }
}
