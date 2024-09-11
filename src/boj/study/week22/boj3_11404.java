package boj.study.week22;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 플로이드 워셜
public class boj3_11404 {
    static int n, m;
    static int[][] graph;
    static final int INF = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[v][w] = Math.min(graph[v][w], cost);
        }

        floyd();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] == INF) bw.write("0 ");
                else bw.write(graph[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.close();
    }
    static void floyd() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
    }
}
