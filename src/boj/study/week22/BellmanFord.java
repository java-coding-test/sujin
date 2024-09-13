package boj.study.week22;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BellmanFord {
    static int N, M, start;
    static int[] dist;
    static ArrayList<Edge_b> graph = new ArrayList<>();
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.add(new Edge_b(v, w, cost));
        }

        if (bellmanFord(start)) {
            for (int i = 1; i < dist.length; i++) {
                if (dist[i] == INF) bw.write("INF ");
                else bw.write(dist[i] + " ");
            }
        } else bw.write("[Error] 음수 사이클 존재");
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean bellmanFord(int start) {
        boolean updated;
        for (int i = 0; i < N - 1; i++) {
            updated = false;
            for (int j = 0; j < M; j++) {
                Edge_b edge = graph.get(j);
                if (dist[edge.v] != INF && dist[edge.w] > dist[edge.v] + edge.cost ) {
                    dist[edge.w] = dist[edge.v] + edge.cost;
                    updated = true;
                }
                if (!updated) break;
            }
        }
        for (int i = 0; i < M; i++) {
            Edge_b edge = graph.get(i);
            if (dist[edge.v] != INF && dist[edge.w] > dist[edge.v] + edge.cost ) {
                return false;
            }
        }
        return true;
    }
}

class Edge_b {
    int v;
    int w;
    int cost;

    public Edge_b(int v, int w, int cost) {
        this.v = v;
        this.w = w;
        this.cost = cost;
    }
}