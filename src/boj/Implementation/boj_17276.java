package boj.Implementation;

import java.io.*;
import java.util.*;

public class boj_17276 {
    static int T;
    static int n, d;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            // 횟수로 치환
            d = ((Integer.parseInt(st.nextToken()) + 360) % 360) / 45;

            arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[] temp = new int[n];

            for (int i = 0; i < d; i++) {
                // 시계방향으로 45도 도는 로직
                for (int k = 0; k < n; k++) {
                    temp[k] = arr[k][k];
                    arr[k][k] = arr[n / 2][k];
                    arr[n / 2][k] = arr[n - 1 - k][k];
                    arr[n - 1 - k][k] = arr[n - 1 - k][n / 2];
                }
                for (int k = 0; k < n; k++) {
                    arr[k][n / 2] = temp[k];
                }

            }

            for (int i = 0; i < n; i++) {
                for (int k = 0; k < n; k++) {
                    bw.write(arr[i][k] + " ");
                }
                bw.write("\n");
            }

        }
        bw.close();
    }
}
