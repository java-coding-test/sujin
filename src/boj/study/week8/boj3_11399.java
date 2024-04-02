package boj.study.week8;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj3_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(P);
        int count = 0;
        int answer = 0;
        for (int i = 0; i < N; i++) {
            count = count + P[i];
            answer += count;
        }
        bw.write(answer + "");
        bw.close();
    }
}
