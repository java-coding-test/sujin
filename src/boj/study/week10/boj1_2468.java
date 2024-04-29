package boj.study.week10;

import java.io.*;
import java.util.StringTokenizer;

public class boj1_2468 {
    public static boolean[][] flood;
    public static int[][] map;
    public static int k;
    public static int N;
    public static int[] dr = {1, -1, 0, 0};
    public static int[] dc = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        int max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                k = Integer.parseInt(st.nextToken());
                map[i][j] = k;
                if (max < k) max = k;


            }
        }
        flood = new boolean[N][N];
        int countMax = 0;
        for (int h = 0; h <= max; h++) {
            init();
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > h && !flood[i][j]) {
                        count += 1;
                        dfs(i, j, h);
                    }
                }
            }
//            bw.write(count+"\n");
            countMax = Math.max(count, countMax);
        }
        bw.write(countMax + "");
        bw.close();
    }
    public static void init() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                flood[i][j] = false;
            }
        }
    }

    public static void dfs(int r, int c, int h) {
        flood[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || nc < 0 || nr >= N || nc >= N
                    || map[nr][nc] <= h || flood[nr][nc]) {
                continue;
            }
            dfs(nr, nc, h);
        }
    }
}
