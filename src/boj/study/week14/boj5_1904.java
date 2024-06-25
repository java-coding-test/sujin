package boj.study.week14;

import java.io.*;

public class boj5_1904 {
    static int arr[] = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= N; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 15746;
        }

        bw.write(arr[N] + "");
        bw.close();
    }

}
