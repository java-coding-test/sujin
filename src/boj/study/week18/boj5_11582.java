package boj.study.week18;

import java.io.*;
import java.util.Arrays;

public class boj5_11582 {
    private static int N, K;
    private static int[] chicken;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        chicken = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i += (N / K)) {
            sort(i, i + N / K);
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static void sort(int start, int end) {
        int[] temp = new int[end - start];
        for (int i = start; i < end; i++) {
            temp[i - start] = chicken[i];
        }
        Arrays.sort(temp);
        for (int i = 0; i < end - start; i++) {
            sb.append(temp[i]).append(" ");
        }
    }
}
