package boj.step_by_step.dfs;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_1012 {

    static int T, M, N, K;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        ArrayList<Integer> list = new ArrayList<>();
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                map[w][v] = 1;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        count++;
                        dfs(i, j);
                    }
                }
            }
            bw.write(count + "\n");

        }
        bw.close();
    }
    public static void dfs(int x, int y) {
        Stack<Point> stack = new Stack<>();

        stack.push(new Point(x, y));
        visited[x][y] = true;

        while (!stack.isEmpty()) {
            Point point = stack.pop();

            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) {
                    continue;
                }

                if (map[nx][ny] == 1) {
                    stack.push(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }

}

class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
