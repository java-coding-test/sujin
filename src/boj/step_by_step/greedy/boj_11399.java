package boj.step_by_step.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_11399 {
    static int N;
    static int[] P;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        P = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(P);

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += P[i] * (N - i);
        }
        bw.write(sum + "");
        bw.close();
    }
}
