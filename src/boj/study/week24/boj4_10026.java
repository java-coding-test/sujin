package boj.study.week24;

import java.io.*;
import java.util.*;

public class boj4_10026 {
    static boolean[][] visited;
    static int N;
    static int[][] map1;
    static int[][] map2;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map1 = new int[N][N];
        map2 = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                switch (str.charAt(j)) {
                    case 'R':
                        map1[i][j] = 0;
                        map2[i][j] = 0;
                        break;
                    case 'B':
                        map1[i][j] = 1;
                        map2[i][j] = 1;
                        break;
                    case 'G':
                        map1[i][j] = 2;
                        map2[i][j] = 0;
                        break;
                }
            }
        }

        bw.write(countArea(map1) + " ");
        bw.write(countArea(map2) + "");
        bw.close();
    }

    public static int countArea(int[][] map) {
        int count = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    count++;
                    bfs(i, j, map);
                }
            }
        }
        return count;
    }

    public static void bfs(int x, int y, int[][] map) {
        Queue<Point_10026> q = new LinkedList<>();
        int currentColor = map[x][y];
        q.add(new Point_10026(x, y));
        visited[x][y] = true;
        while (!q.isEmpty()) {
            Point_10026 current = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && map[nx][ny] == currentColor) {
                    visited[nx][ny] = true;
                    q.add(new Point_10026(nx, ny));
                }
            }
        }
    }
}
class Point_10026 {
    int x, y;
    Point_10026(int x, int y) {
        this.x = x;
        this.y = y;
    }
}