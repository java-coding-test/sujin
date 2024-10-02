package boj.step_by_step.implementation;

import java.io.*;
import java.util.StringTokenizer;

public class boj_2960 {
    static int N, K;
    static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        num = new int[N + 1];
        int count = 0;

        for (int i = 2; i < N + 1; i++) {
            num[i] = i;
        }


        for (int i = 2; i < N + 1; i++) {

            if (num[i] != 0) {
                int k = i;
                while (k <= N) {
                    if (num[k] != 0) {
                        count++;
//                        System.out.println("count: " + count + ", num[k]: " + num[k]);
                        if (count == K) {
                            bw.write(num[k] + "");
                            break;
                        }
                        num[k] = 0;
                    }
                    k += i;
                }
                if (count == K) break;
            }
        }
        bw.close();


    }
}
