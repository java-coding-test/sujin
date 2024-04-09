package boj.study.week9;

import java.io.*;
import java.math.BigInteger;

public class boj1_10826 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        BigInteger[] dp = new BigInteger[N + 1];
        // N 이 0일 때, ArrayIndex 에러 뜸
//        dp[1] = BigInteger.ONE; -> 이게 불가 하기 때문
        if (N == 0) {
            bw.write("0");
        } else if (N == 1) {
            bw.write("1");
        } else {
            dp[0] = BigInteger.ZERO;
            dp[1] = BigInteger.ONE;
            for (int i = 2; i <= N; i++) {
                dp[i] = dp[i - 2].add(dp[i - 1]);
            }
            bw.write(dp[N] + "");
        }
        bw.close();
    }
}
