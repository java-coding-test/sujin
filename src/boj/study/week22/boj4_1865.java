package boj.study.week22;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj4_1865 {
    static int TC;
    static int N, M, W;
    static ArrayList<Edge_1865> graph;
    static int[] dist;
    static final int INF = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        TC = Integer.parseInt(br.readLine());



        for (int k = 0; k < TC; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            dist = new int[N + 1];
            graph = new ArrayList<>();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                graph.add(new Edge_1865(v, w, cost));
                graph.add(new Edge_1865(w, v, cost));
            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                graph.add(new Edge_1865(v, w, -cost));
            }

            Arrays.fill(dist, 0);

            bw.write(bellmanFord() + "\n");
        }

        bw.close();
    }

    public static String bellmanFord() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < graph.size(); j++) {
                Edge_1865 edge = graph.get(j);

                if (dist[edge.v] != INF && dist[edge.w] > dist[edge.v] + edge.cost) {
                    dist[edge.w] = dist[edge.v] + edge.cost;
                }
            }

        }
        for (int i = 0; i < graph.size(); i++) {
            Edge_1865 edge = graph.get(i);

            if (dist[edge.v] != INF && dist[edge.w] > dist[edge.v] + edge.cost) {
                return "YES";
            }
        }
        return "NO";
    }

}

class Edge_1865 {
    int v;
    int w;
    int cost;

    public Edge_1865(int v, int w, int cost) {
        this.v = v;
        this.w = w;
        this.cost = cost;
    }
}