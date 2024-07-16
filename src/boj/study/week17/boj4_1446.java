package boj.study.week17;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// boj 1446
// 다익스트라
class Node {
    int node;
    int weight;

    Node(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}
public class boj4_1446 {
    static int N, D;
    static List<List<Node>> graph = new ArrayList<>();
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 10001; i++) {
            graph.add(new ArrayList<>());
        }
        distance = new int[10001];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = i;
        }
        int a, b, w;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, w));
        }
        dijkstra(0);

        bw.write(distance[D] + "");
        bw.flush();
        br.close();
        bw.close();
    }

    static void dijkstra(int start) {
        if (start > D) return;
        if (distance[start + 1] > distance[start] + 1) distance[start + 1] = distance[start] + 1;
        for (int i = 0; i < graph.get(start).size(); i++) {
            if (distance[start] + graph.get(start).get(i).weight < distance[graph.get(start).get(i).node]) {
                distance[graph.get(start).get(i).node] = distance[start] + graph.get(start).get(i).weight;
            }
        }
        dijkstra(start + 1);
    }
}
