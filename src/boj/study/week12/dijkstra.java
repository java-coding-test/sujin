package boj.study.week12;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
    int idx;
    int weight;

    Node(int idx, int weight) {
        this.idx = idx;
        this.weight = weight;
    }
}
public class dijkstra {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        for (int i = 0; i < V + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, weight));
        }

        boolean[] visited = new boolean[V + 1];
        int[] dist = new int[V + 1];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[X] = 0;

        // 다익스트라 알고리즘의 시작
        for (int i = 0; i < V; i++) {
            int nodeValue = Integer.MAX_VALUE;
            int nodeIdx = 0;

            // 아직 방문하지 않은 노드 중 가장 거리가 가까운 노드 찾기
            for (int j = 1; j < V + 1; j++) {
                if (!visited[j] && dist[j] < nodeValue) {
                    nodeValue = dist[j];
                    nodeIdx = j;
                }
            }

            visited[nodeIdx] = true;

            for (int j = 0; j < graph.get(nodeIdx).size(); j++) {
                // 인접 노드를 선택한다.
                Node adjNode = graph.get(nodeIdx).get(j);

                if (dist[adjNode.idx] > dist[nodeIdx] + adjNode.weight) {
                    dist[adjNode.idx] = dist[nodeIdx] + adjNode.weight;
                }
            }
        }

        for (int i = 1; i < V + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                bw.write("INF");
            } else {
                bw.write(dist[i] + " ");
            }
        }
        bw.close();
    }
}
