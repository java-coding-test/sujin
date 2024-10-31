package boj.SlidingWindow_TwoPointer;

import java.io.*;
import java.util.*;

public class boj_2559 {
    static int N, K;
    static int[] arr;
    static int max;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += arr[i];
        }
        max = sum;

        for (int i = K; i < N; i++) {
            sum -= arr[i - K];
            sum += arr[i];
            if (max < sum) max = sum;
        }

        bw.write(max + "\n");
        bw.close();

    }
}
