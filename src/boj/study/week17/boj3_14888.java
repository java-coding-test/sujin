package boj.study.week17;

import java.io.*;
import java.util.StringTokenizer;

public class boj3_14888 {
    static int N;
    static int[] number;
    static int[] operator;

    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        number = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        operator = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }


        dfs(number[0], 1);
        bw.write(MAX + "\n" + MIN);
        bw.flush();
        br.close();
        bw.close();

    }
    public static void dfs(int num, int idx) {
        if (idx == N) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;

                switch (i) {
                    case 0: {
                        dfs(num + number[idx], idx + 1);
                        break;
                    }
                    case 1: {
                        dfs(num - number[idx], idx + 1);
                        break;
                    }
                    case 2: {
                        dfs(num * number[idx], idx + 1);
                        break;
                    }
                    case 3: {
                        dfs(num / number[idx], idx + 1);
                        break;
                    }
                }
                operator[i]++;
            }
        }
    }
}
