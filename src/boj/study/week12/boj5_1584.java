package boj.study.week12;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;


public class boj5_1584 {

    static class Point {
        int y;
        int x;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int WARNING_ZONE = 1;
    static int DEATH_ZONE = -1;
    static int[][] zone = new int[501][501];
    static int[][] value = new int[501][501];

    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 501; i++) {
            for (int j = 0; j < 501; j++) {
                value[i][j] = Integer.MAX_VALUE;
            }
        }
        value[0][0] = 0;

        int N = Integer.parseInt(br.readLine());
        setZone(N, WARNING_ZONE);


        int M = Integer.parseInt(br.readLine());
        setZone(M, DEATH_ZONE);

        zone[0][0] = 0;

        bfs(0, 0);

        if (value[500][500] == Integer.MAX_VALUE) {
            bw.write(-1 + "");
        } else {
            bw.write(value[500][500] + "");
        }
        bw.close();
    }

    private static void setZone(int times, int zoneNum) throws IOException {

        for (int i = 0; i < times; i++) {
            String[] point = br.readLine().split(" ");
            int x1 = Integer.parseInt(point[0]);
            int y1 = Integer.parseInt(point[1]);
            int x2 = Integer.parseInt(point[2]);
            int y2 = Integer.parseInt(point[3]);
            for (int j = Math.min(x1, x2); j <= Math.max(x1, x2); j++) {
                for (int k = Math.min(y1, y2); k <= Math.max(y1, y2); k++) {
                    zone[j][k] = zoneNum;
                }
            }
        }
    }

    public static void bfs(int startX, int startY) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startX, startY));

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            int[] dy = {1, -1, 0, 0};
            int[] dx = {0, 0, 1, -1};

            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + cur.y;
                int nx = dx[i] + cur.x;

                if (nx < 0 || ny < 0 || nx > 500 || ny > 500) {
                    continue;
                }
                if (zone[nx][ny] == -1) {
                    continue;
                }

                int newCost = value[cur.x][cur.y] + zone[nx][ny];

                if (value[nx][ny] > newCost) {
                    value[nx][ny] = newCost;
                    queue.add(new Point(nx, ny));
                }
            }
        }
    }
}
