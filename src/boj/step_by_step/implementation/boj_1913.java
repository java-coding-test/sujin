package boj.step_by_step.implementation;

import java.io.*;

public class boj_1913 {
    static int N;
    static int num;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        num = Integer.parseInt(br.readLine());

        map = new int[N][N];

        int x = 0, y = 0;
        int nx, ny;
        int value = N * N;
        int idx = 0;
        int targetX = 0, targetY = 0;

        while(value > 0) {
            map[x][y] = value;
            if (value == num) {
                targetX = x;
                targetY = y;
            }

            nx = x + dx[idx];
            ny = y + dy[idx];

            if (nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1 || map[nx][ny] != 0) {
                idx = (idx + 1) % 4;
                nx = x + dx[idx];
                ny = y + dy[idx];
            }
            x = nx;
            y = ny;
            value--;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(map[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.write((targetX + 1) + " " + (targetY + 1));
        bw.close();
    }
}
