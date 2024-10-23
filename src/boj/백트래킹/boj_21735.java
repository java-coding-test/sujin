package boj.백트래킹;

import java.io.*;
import java.util.*;

public class boj_21735 {
    static int N, M;
    static int[] arr;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 1);
        bw.write(max + "");
        bw.close();
    }

    static void dfs(int depth, int x, int value) {
        if (depth >= M) {
            max = Math.max(max, value);
            return;
        }

        for (int i = 1; i < 3; i++) {
            int nx = x + i;

            if (nx <= N) {
                if (i == 1) dfs(depth + 1, nx, value + arr[nx]);
                else dfs(depth + 1, nx, (value / 2) + arr[nx]);
            } else {
                max = Math.max(max, value);
            }
        }
    }
}
