package boj.study.week9;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 11724번 연결 요소의 개수
 *
 * 방향 없는 그래프가 주어졌을 때,
 * 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
 *
 */
public class boj4_11724 {
    public static int N;
    public static int[][] edge;
    public static int count = 0;
    public static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        edge = new int[N + 1][N + 1];
        visited = new int[N + 1];

        int u, v;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            edge[u][v] = edge[v][u] = 1;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i] == 0) {
                count++;
                dfs(i);
            }
        }

        bw.write(count + "");
        bw.close();
    }

    public static void dfs(int node) {
        visited[node] = 1;
        for (int i = 1; i <= N; i++) {
            if (edge[node][i] == 1 && visited[i] == 0) {
                dfs(i);
            }
        }
    }
}
