package boj.study.week21;

import java.io.*;
import java.util.*;

public class boj3_1504 {
    static int N, E;
    static boolean[] visited;
    static ArrayList<Node>[] graph;
    static int[] dist;
    static final int INF = 200_000_000;

    static int v1, v2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        dist = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        int start, end, cost;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, cost));
            graph[end].add(new Node(start, cost));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());
        long result = Math.min(calculatePath(v1, v2), calculatePath(v2, v1));
        bw.write((result >= INF ? -1 : result) + "");
        bw.close();
    }

    static long calculatePath(int v1, int v2) {
        long dist1 = dijkstra(1, v1);
        long dist2 = dijkstra(v1, v2);
        long dist3 = dijkstra(v2, N);

        if (dist1 >= INF || dist2 >= INF || dist3 >= INF) {
            return INF;
        }

        return dist1 + dist2 + dist3;
    }

    static int dijkstra(int start, int end) {
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {

            Node current = pq.poll();
            int nowVertex = current.node;
            if (nowVertex == end) return dist[end];

            for (Node node : graph[nowVertex]) {
                int newDist = dist[nowVertex] + node.cost;
                if (newDist < dist[node.node]){
                    pq.offer(new Node(node.node, newDist));
                    dist[node.node] = newDist;
                }
            }
        }
        return dist[end];
    }
}

class Node implements Comparable<Node>{
    int node;
    int cost;

    public Node(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost, o.cost);
    }
}