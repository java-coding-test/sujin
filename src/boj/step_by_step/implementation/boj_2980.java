package boj.step_by_step.implementation;

import java.io.*;
import java.util.StringTokenizer;

public class boj_2980 {
    static int N, L;
    static int[][] spot;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        spot = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                spot[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int sum = 0;
        int cycle, last;
        int loc = 0;
        for (int i = 0; i < N; i++) {

            sum += spot[i][0] - loc;
            cycle = spot[i][1] + spot[i][2];
            last = sum % cycle;
            if (last < spot[i][1]) {
                sum += spot[i][1] - last;
            }
            loc = spot[i][0];
        }
        sum += L - loc;
        bw.write(sum + "");
        bw.close();
    }
}
