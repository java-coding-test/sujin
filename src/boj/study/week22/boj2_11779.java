package boj.study.week22;

import java.io.*;
import java.util.*;

// 다익스트라 + 경로추작
public class boj2_11779 {
    static int n, m;
    static ArrayList<Node_11779>[] graph;
    static int[] dist;
    static int[] parent;
    static int INF = Integer.MAX_VALUE;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        dist = new int[n + 1];
        Arrays.fill(dist, INF);

        parent = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int origin = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[origin].add(new Node_11779(dest, cost));
        }

        st = new StringTokenizer(br.readLine());
        int origin = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());

        dijkstra(origin, dest);
        bw.write(dist[dest] + "\n");
        printPath(origin, dest);
        bw.close();
    }

    static void dijkstra(int origin, int dest) throws IOException {
        PriorityQueue<Node_11779> pq = new PriorityQueue<>();
        pq.offer(new Node_11779(origin, 0));
        dist[origin] = 0;

        while (!pq.isEmpty()) {
            Node_11779 current = pq.poll();
            int curVertex = current.dest;

            if (curVertex == dest) return;

            for (Node_11779 node : graph[curVertex]) {
                if (dist[node.dest] > dist[curVertex] + node.cost) {
                    dist[node.dest] = dist[curVertex] + node.cost;
                    pq.offer(new Node_11779(node.dest, dist[node.dest]));

                    parent[node.dest] = curVertex;
                }
            }
        }
    }

    static void printPath(int start, int dest) throws IOException {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int vertex = dest;
        stack.add(vertex);
        while (vertex != start) {
            vertex = parent[vertex];
            stack.add(vertex);
        }

        bw.write(stack.size() + "\n");
        while (!stack.isEmpty()) {
            int node = stack.pop();
            sb.append(node).append(" ");
        }
        bw.write(sb.toString());
    }
}
class Node_11779 implements Comparable<Node_11779>{
    int dest;
    int cost;

    public Node_11779(int dest, int cost) {
        this.dest = dest;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node_11779 o) {
        return Integer.compare(this.cost, o.cost);
    }
}
