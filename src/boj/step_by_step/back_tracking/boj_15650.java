package boj.step_by_step.back_tracking;

import java.io.*;
import java.util.*;

public class boj_15650 {
    static int N, M;
    static boolean[] visited;
    static int[] arr;

    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visited = new boolean[N];

        dfs(0);
        bw.close();
    }

    public static void dfs(int depth) throws IOException{
        if (depth == M) {
            for (int val: arr) {
                bw.write(val + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                if (depth != 0) {
                    if (arr[depth - 1] < i + 1) {
                        visited[i] = true;
                        arr[depth] = i + 1;
                        dfs(depth + 1);
                        visited[i] = false;
                    }
                } else {
                    visited[i] = true;
                    arr[depth] = i + 1;
                    dfs(depth + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
