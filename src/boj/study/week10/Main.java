package boj.study.week10;

import java.io.*;

public class Main {
    public static int[] dp;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[N + 1];

        dp[0] = arr[0];
        dp[1] = arr[1];
        if (N >= 2) {
            dp[2] = dp[1] + arr[2];
        }

        bw.write(find(N) + "");
    }

    public static int find(int N) {

        if (dp[N] == 0) {
            dp[N] = Math.max(find(N - 2), find(N - 3) + arr[N - 1]) + arr[N];
        }

        return dp[N];
    }

}
