package boj.study.week13;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class kruskal {
    static int V, E;
    static int[][] graph;

    static int[] parent;

    static int final_cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new int[E][3];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
        }

        parent = new int[V];
        final_cost = 0;

        Arrays.sort(graph, (o1, o2) ->
                Integer.compare(o1[2], o2[2]));

        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < E; i++) {
            if (find(graph[i][0] - 1) != find(graph[i][1] - 1)) {
                union(graph[i][0] - 1, graph[i][1] - 1);
                final_cost += graph[i][2];
                continue;
            }
        }
        bw.write(final_cost + "");
        bw.close();
    }
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }

    private static int find(int x) {
        if (parent[x] == x)
            return x;
        else
            return find(parent[x]);
    }
}

