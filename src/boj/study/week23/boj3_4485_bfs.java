package boj.study.week23;

import java.io.*;
import java.util.*;

public class boj3_4485_bfs {
    static int N;
    static int[][] map;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static boolean[][] visited;

    static int count;
    static int MAX = Integer.MAX_VALUE;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        while (!(str = br.readLine()).equals("0")) {
            count++;
            N = Integer.parseInt(str);

            map = new int[N][N];
            visited = new boolean[N][N];
            dist = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                Arrays.fill(dist[i], MAX);
            }

            bfs();
            bw.write("Problem " + count + ": " + dist[N - 1][N - 1] + "\n");
        }
        bw.close();
    }

    public static void bfs() {
        PriorityQueue<Point_4485_bfs> q = new PriorityQueue<>();
        dist[0][0] = map[0][0];
        q.offer(new Point_4485_bfs(0, 0, map[0][0]));

        while (!q.isEmpty()) {
            Point_4485_bfs current = q.poll();
            visited[current.x][current.y] = true;
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    if (dist[nx][ny] > dist[current.x][current.y] + map[nx][ny]) {
                        dist[nx][ny] = dist[current.x][current.y] + map[nx][ny];
                        q.offer(new Point_4485_bfs(nx, ny, dist[nx][ny]));
                    }
                }
            }
        }
    }
}

class Point_4485_bfs implements Comparable<Point_4485_bfs> {
    int x, y, cost;
    public Point_4485_bfs(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(Point_4485_bfs o) {
        return this.cost - o.cost;
    }
}
