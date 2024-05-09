package boj.study.week11;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 케빈 베이컨의 6단계 법칙
public class boj4_1389 {
    public static int N, M;
    static int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int edge[][] = new int[N + 1][N + 1];
        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(edge[i], INF);
        }
        int u, v;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            edge[u][v] = edge[v][u] = 1;
        }

//        for (int i = 1; i < N + 1; i++) {
//            for (int j = 1; j < N + 1; j++) {
//                bw.write(edge[i][j] + " ");
//            }
//            bw.write("\n");
//        }


        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                for (int k = 1; k < N + 1; k++) {
                    edge[j][k] = Math.min(edge[j][i] + edge[i][k], edge[j][k]);
                }
            }
        }
//        for (int i = 1; i < N + 1; i++) {
//            for (int j = 1; j < N + 1; j++) {
//                bw.write(edge[i][j] + " ");
//            }
//            bw.write("\n");
//        }

        bw.write(output(edge) + "");
        bw.close();
    }

    public static int output(int edge[][]) {
        int minIdx = 0;
        int min = Integer.MAX_VALUE;
        int[] sumArr = new int[N + 1];
        int sum;
        for (int i = 1; i < N + 1; i++) {
            sum = 0;
            for (int j = 1; j < N + 1; j++) {
                sum += edge[i][j];
            }
            sumArr[i] = sum;
        }
//        for (int i = 1; i < N + 1; i++) {
//            System.out.print(sumArr[i] + " ");
//        }
//        System.out.println();

        for (int i = 1; i < N + 1; i++) {
            if (min > sumArr[i]) {
                min = sumArr[i];
                minIdx = i;
            }
        }
        return minIdx;
    }
}
