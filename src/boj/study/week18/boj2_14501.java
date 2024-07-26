package boj.study.week18;

import java.io.*;
import java.util.StringTokenizer;

public class boj2_14501 {
    static int N;
    static int[][] consulting;
    static double[] weighted;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        consulting = new int[N][2];
        weighted = new double[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            consulting[i][0] = Integer.parseInt(st.nextToken());
            consulting[i][1] = Integer.parseInt(st.nextToken());
        }

        result = 0;
        dfs(0, 0);

        bw.write(result + "");
        bw.close();
        br.close();
    }

    // idx = 날짜 수
    static void dfs(int idx, int pay) {
        if (idx >= N) {
            result = Math.max(pay, result);
            return;
        }
        if (idx + consulting[idx][0] <= N) {
            dfs(idx + consulting[idx][0], pay + consulting[idx][1]);
        } else {
            dfs(idx + consulting[idx][0], pay);
        }

        dfs(idx + 1, pay);
    }
}
