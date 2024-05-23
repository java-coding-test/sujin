package boj.study.week12;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj7_11657 {
    static class Edge {
        int v;
        int w;
        int cost;

        public Edge(int v, int w, int cost) {
            this.v = v;
            this.w = w;
            this.cost = cost;
        }
    }
    static int MAX = Integer.MAX_VALUE;
    static long[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        dist = new long[N + 1];
        Arrays.fill(dist, MAX);
        dist[1] = 0;

        ArrayList<Edge> graph = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph.add(new Edge(A, B, C));
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                Edge edge = graph.get(j);
                if (dist[edge.v] != MAX && dist[edge.w] > dist[edge.v] + edge.cost) {
                    dist[edge.w] = dist[edge.v] + edge.cost;
                }
            }
        }
        boolean flag = false;
        for (int i = 0; i < M; i++) {
            Edge edge = graph.get(i);
            if (dist[edge.v] != MAX && dist[edge.w] > dist[edge.v] + edge.cost) {
                flag = true;
                break;
            }
        }
//        for (int x : dist) {
//            System.out.print(x + " ");
//        }
//        System.out.println();
//        System.out.println("flag = " + flag);
        if (flag) {
            bw.write("-1\n");
        } else {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == MAX) {
                    bw.write("-1\n");
                } else {
                    bw.write(dist[i] + "\n");
                }
            }
        }
        bw.close();
    }
}
