package boj.BruteForce;

import java.io.*;
import java.util.*;

public class boj_1018 {
    static int N, M;
    static char[][] map;
    static char[][] chess = new char[8][8];
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken().trim());
        M = Integer.parseInt(st.nextToken().trim());

        map = new char[N][M];
        chess = new char[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                calCount(i, j);
            }
        }

        bw.write(MIN + "");
        bw.close();



    }

    static void calCount(int x, int y) {
        int BCount = 0;
        boolean beforeBlackFlag = !(map[x][y] == 'B');
        for (int i = x; i < x + 8; i++) {
            beforeBlackFlag = !beforeBlackFlag;
            for (int j = y; j < y + 8; j++) {
                if (beforeBlackFlag && map[i][j] == 'B') BCount++;
                else if (!beforeBlackFlag && map[i][j] == 'W') BCount++;
                beforeBlackFlag = !beforeBlackFlag;
            }
        }

        int min = Math.min(BCount, (64) - BCount);
        MIN = Math.min(MIN, min);
    }

}
