package boj.study.week9;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj5_11725 {
    public static boolean[] visited;
    public static int[] parent;
    public static ArrayList<Integer>[] edge;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        edge = new ArrayList[N + 1];
        parent = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            edge[i] = new ArrayList<>();
        }

        StringTokenizer st;
        int u, v;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            edge[u].add(v);
            edge[v].add(u);
        }
        dfs(1);

        for (int i = 2; i < parent.length; i++) {
            bw.write(parent[i] + "\n");
        }
        bw.close();
    }
    public static void dfs(int index) {
        visited[index] = true;
        for (int i : edge[index]) {
            if (!visited[i]) {
                parent[i] = index;
                dfs(i);
            }
        }
    }
}
