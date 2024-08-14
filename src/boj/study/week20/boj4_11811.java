package boj.study.week20;

import java.io.*;
import java.util.StringTokenizer;

public class boj4_11811 {
    static int N;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        int[] ans = new int[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                ans[i] = ans[i] | arr[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            bw.write(ans[i] + " ");
        }
        bw.close();
    }
}
