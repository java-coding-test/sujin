package boj.step_by_step.implementation;

import java.io.*;

public class snail {
    static int N;
    static int print;
    static int[][] snail;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        print = N;
        snail = new int[N][N];

        int count = 0;
        snail[0][0] = count;

        int x = -1, y = 0;
        int idx = 0;
        while (print != 0) {

            for (int i = 0; i < print; i++) {
                x += dx[idx];
                y += dy[idx];
                snail[y][x] = ++count;
            }

            print--;
            idx = (idx + 1) % 4;

            for (int i = 0; i < print; i++) {
                x += dx[idx];
                y += dy[idx];
                snail[y][x] = ++count;
            }

            idx = (idx + 1) % 4;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(snail[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.close();
    }
}
