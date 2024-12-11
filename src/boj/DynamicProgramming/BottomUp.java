package boj.DynamicProgramming;

import java.io.*;
import java.util.*;

public class BottomUp {
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = 10;
        dp = new int[n + 1];

        bw.write(fib(n) + "");
        bw.close();
    }
    static int fib(int n) {
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
