package boj.study.week25;

import java.io.*;
import java.util.*;

public class boj6_14503 {
    static int N, M;
    static int[][] map;
    static int d;
    static int count;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int nx, ny;
        while (true) {
            if (map[x][y] == 0) {
                count++;
                map[x][y] = -1;
            }
            int i;
            for (i = 0; i < 4; i++) {
                d = (d + 3) % 4;
                nx = x + dx[d];
                ny = y + dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nx][ny] == 0) {
                        x = nx; y = ny;
                        break;
                    }
                }
            }
            if (i == 4) {
                nx = x + dx[(d + 2) % 4];
                ny = y + dy[(d + 2) % 4];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 1) break;
                else {
                    x = nx; y = ny;
                }
            }
        }
        bw.write(count + "");
        bw.close();

    }
}
