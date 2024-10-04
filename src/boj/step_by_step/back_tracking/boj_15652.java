package boj.step_by_step.back_tracking;

import java.io.*;
import java.util.*;

public class boj_15652 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(0);
        bw.close();
    }

    public static void dfs(int depth) throws IOException{
        if (depth == M) {
            for (int val : arr) {
                bw.write(val + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (depth != 0) {
                if (arr[depth - 1] <= i + 1) {
                    arr[depth] = i + 1;
                    dfs(depth + 1);
                }
            } else {
                arr[depth] = i + 1;
                dfs(depth + 1);
            }
        }
    }
}
