package boj.study.week22;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1_1261 {
    static int N, M;
    static int[][] graph, dist;
    static int INF = Integer.MAX_VALUE;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[M + 1][N + 1];
        dist = new int[M + 1][N + 1];
        String str;
        for (int i = 1; i < M + 1; i++) {
            str = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j + 1] = str.charAt(j) - '0';
                dist[i][j + 1] = INF;
            }

        }
        dijkstra();
        bw.write(dist[M][N] + "");
        bw.close();
    }

    public static void dijkstra() {
        PriorityQueue<Node_1261> pq = new PriorityQueue<>();
        pq.offer(new Node_1261(1, 1, 0));
        dist[1][1] = 0;

        int x, y;
        while (!pq.isEmpty()) {
            Node_1261 current = pq.poll();
            x = current.x;
            y = current.y;
            if (x == M && y == N) break;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx > M || ny < 0 || ny > N) continue;

                int newDist = dist[x][y] + graph[nx][ny];
                if (newDist < dist[nx][ny]) {
                    dist[nx][ny] = newDist;
                    pq.offer(new Node_1261(nx, ny, newDist));
                }
            }
        }
    }
}

class Node_1261 implements Comparable<Node_1261> {
    int x, y, cost;

    public Node_1261(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }


    @Override
    public int compareTo(Node_1261 o) {
        return Integer.compare(this.cost, o.cost);
    }
}
