package boj.study.week24;

import java.io.*;
import java.util.StringTokenizer;

public class boj3_30804 {
    static int N;
    static int[] S;
    static int[] count;
    static int max = -1;
    static int distinct;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        S = new int[N];
        count = new int[10];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0;
        while (end < N) {
            if (count[S[end]] == 0) distinct++;
            count[S[end]]++;

            while (distinct > 2) {
                count[S[start]]--;
                if (count[S[start]] == 0) distinct--;
                start++;
            }

            max = Math.max(max, end - start + 1);
            end++;
        }


        bw.write(max + "");
        bw.close();
    }
}
