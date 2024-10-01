package boj.step_by_step.implementation;

// 1018번 체스판 다시 칠하기

import java.io.*;
import java.util.StringTokenizer;

public class boj_1018 {
    static int N, M;
    static boolean[][] map;
    static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N + 1][M + 1];
        String[] temp;
        for (int i = 0; i < N; i++) {
            temp = br.readLine().split("");
            for (int j = 0; j < temp.length; j++) {
                map[i][j] = temp[j].equals("W");
            }
        }
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int cnt = find(i, j);
                if (min > cnt) {
                    min = cnt;
                }
            }
        }

        bw.write(min + "");
        bw.close();
    }

    public static int find(int x, int y) {
        boolean TF = false;
        int count = 0;
        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (map[i][j] != TF) {
                    count++;
                }
                TF = !TF;
            }
            TF = !TF;
        }
        return Math.min(count, 64 - count);
    }
}
