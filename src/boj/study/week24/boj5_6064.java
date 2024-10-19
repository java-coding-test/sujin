package boj.study.week24;

import java.io.*;
import java.util.*;

public class boj5_6064 {
    static int T;
    static int M, N, x, y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
//            System.out.println("M = " + M);
//            System.out.println("N = " + N);
//            System.out.println("x = " + x);
//            System.out.println("y = " + y);

            int j;
            boolean flag = false;
            for (j = x; j < x + lcm(M, N); j += M) {
                if (j % N == y % N) {
                    bw.write(j + "\n");
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                bw.write("-1\n");
            }

        }
        bw.close();
    }

    public static int lcm(int a, int b) {
        return (b / gcd(a, b)) * a;
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
