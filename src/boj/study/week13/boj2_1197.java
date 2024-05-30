package boj.study.week13;

import java.io.*;
import java.util.*;

public class boj2_1197 {
    static int[] parent;
    static class Node implements Comparable<Node> {
        int start;
        int end;
        int weight;

        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }


        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.weight, n.weight);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        Node[] nodes = new Node[E];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(A, B, C);
        }

        Arrays.sort(nodes);

        int final_cost = 0;
        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < E; i++) {
            if (find(nodes[i].start) != find(nodes[i].end)) {
                union(nodes[i].start, nodes[i].end);
                final_cost += nodes[i].weight;
            }
        }
        bw.write(final_cost + "");
        bw.close();
    }
    static int find(int A){
        if(parent[A] == A)
            return A;
        else
            return find(parent[A]);

    }

    static void union(int A, int B){
        int a = find(A);
        int b = find(B);

        if(a != b)
            parent[b] = a;
    }
}
