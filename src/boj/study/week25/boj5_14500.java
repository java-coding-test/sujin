package boj.study.week25;

import java.io.*;
import java.util.*;

public class boj5_14500 {
    static int N, M;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(1, new Point(j, i, map[i][j]));
                visited[i][j] = false;
                checkSpecial(j, i);
            }
        }

        bw.write(max + "");
        bw.close();
    }

    static void dfs(int depth, Point p) {
        if (depth == 4) {
            max = Math.max(max, p.value);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = p.x + dx[i];
            int ny = p.y + dy[i];
            if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[ny][nx]) {
                visited[ny][nx] = true;
                dfs(depth + 1, new Point(nx, ny, p.value + map[ny][nx]));
                visited[ny][nx] = false;
            }
        }
    }

    static void checkSpecial(int x, int y) {
        // ㅗ 모양
        if (x >= 1 && x < M - 1 && y >= 1 && y < N) {
            max = Math.max(max, map[y][x] + map[y][x - 1] + map[y - 1][x] + map[y][x + 1]);
        }

        // ㅜ
        if (x >= 1 && x < M - 1 && y >= 0 && y < N - 1) {
            max = Math.max(max, map[y][x] + map[y][x - 1] + map[y + 1][x] + map[y][x + 1]);
        }

        // ㅏ
        if (x >= 0 && x < M - 1 && y >= 1 && y < N - 1) {
            max = Math.max(max, map[y][x] + map[y][x + 1] + map[y - 1][x] + map[y + 1][x]);
        }

        // ㅓ
        if (x >= 1 && x < M && y >= 1 && y < N - 1) {
            max = Math.max(max, map[y][x] + map[y][x - 1] + map[y - 1][x] + map[y + 1][x]);
        }
    }

    static class Point {
        int x, y, value;
        public Point(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}


