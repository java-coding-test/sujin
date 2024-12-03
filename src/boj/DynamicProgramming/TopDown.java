package boj.DynamicProgramming;

import java.util.*;
import java.io.*;

public class TopDown {
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = 10;
        dp = new int[n + 1];

        bw.write(fib(10) + "");
        bw.close();
    }

    static int fib(int n) {
        if (n <= 1) return n;

        if (dp[n] != 0) return dp[n];

        dp[n] = fib(n - 1) + fib(n - 2);
        return dp[n];
    }


}
