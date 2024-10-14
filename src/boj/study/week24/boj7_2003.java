package boj.study.week24;

import java.io.*;
import java.util.StringTokenizer;

public class boj7_2003 {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = arr[0];
        int count = 0;

        while (start < N && end < N) {
            if (sum == M) {
                count++;
                sum -= arr[start];
                start++;
            } else if (sum > M) {
                sum -= arr[start];
                start++;
            } else {
                end++;
                if (end < N) {
                    sum += arr[end];
                }
            }
        }

        bw.write(count + "");
        bw.close();
    }
}
