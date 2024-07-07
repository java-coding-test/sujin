package boj.study.week16;

import java.io.*;
import java.util.StringTokenizer;

public class boj3_10830 {
    static int N;
    static int origin[][];
    static final int MOD = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        origin = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                origin[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }

        int[][] result = pow(origin, B);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(result[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.close();
    }
    public static int[][] pow(int[][] A, long exp) {
        if (exp ==1L) return A;

        int[][] ret = pow(A, exp / 2);

        ret = multiply(ret, ret);

        if (exp % 2 == 1) {
            ret = multiply(ret, origin);
        }
        return ret;
    }

    public static int[][] multiply(int[][] o1, int[][] o2) {
        int[][] ret = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    ret[i][j] += o1[i][k] * o2[k][j];
                    ret[i][j] %= MOD;
                }
            }
        }
        return ret;
    }
}
