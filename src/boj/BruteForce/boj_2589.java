package boj.BruteForce;

import java.io.*;
import java.util.*;

public class boj_2589 {
    static int N, M; //행, 열
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        // 육지(L) = 0, 바다(W) = 1
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            int count = 0;
            for (char c : str.toCharArray()) {
                if (c == 'L') {
                    map[i][count++] = 0;
                } else {
                    map[i][count++] = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) bfs(i, j);
            }
        }


        bw.write(time + "");
        bw.close();

    }

    static private void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y, 0));
        boolean[][] visited = new boolean[N][M];
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 1 || visited[nx][ny]) continue;
                else {
                    visited[nx][ny] = true;
                    time = Math.max(time, point.time + 1);
                    queue.add(new Point(nx, ny, point.time + 1));
                }
            }

        }

    }

    static class Point {
        int x, y, time;
        public Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
