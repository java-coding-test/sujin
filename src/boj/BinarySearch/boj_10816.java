package boj.BinarySearch;

import java.io.*;
import java.util.*;

public class boj_10816 {
    static int N, M;
    static int[] numN;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        numN = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numN[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numN);

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());
            sb.append((upperBound(key) - lowerBound(key))).append(" ");
        }

        bw.write(sb.toString().trim());
        bw.close();
    }

    static int lowerBound(int key) {
        int start = 0;
        int end = N;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (key <= numN[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    static int upperBound(int key) {
        int start = 0;
        int end = N;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (key < numN[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
