package boj.BruteForce;

import java.io.*;

// 네 종류 C, P, Z, Y

public class boj_3085 {
    static int N;
    static String[][] map;
    static int max = 1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        map = new String[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            map[i] = str.split("");
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                swap(j, i, j + 1, i);
                max = Math.max(max, calculateMax());
                swap(j, i, j + 1, i);

                swap(i, j, i, j + 1);
                max = Math.max(max, calculateMax());
                swap(i, j, i, j + 1);
            }
        }
        bw.write(max + "");
        bw.close();
    }

    private static void swap(int x1, int y1, int x2, int y2) {
        String temp = map[x1][y1];
        map[x1][y1] = map[x2][y2];
        map[x2][y2] = temp;
    }

    private static int calculateMax() {
        int max = 1;
        int colLen;
        int rowLen;

        for (int i = 0; i < N; i++) {
            colLen = rowLen = 1;
            for (int j = 0; j < N - 1; j++) {
                // 행 검사
                if (map[i][j].equals(map[i][j + 1])) {
                    colLen++;
                } else {
                    max = Math.max(max, colLen);
                    colLen = 1;
                }

                // 열 검사
                if (map[j][i].equals(map[j + 1][i])) {
                    rowLen++;
                } else {
                    max = Math.max(max, rowLen);
                    rowLen = 1;
                }
            }

            max = Math.max(max, colLen);
            max = Math.max(max, rowLen);
        }
        return max;
    }
}


