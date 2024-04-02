package boj.study.week8;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj2_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] time = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < 2; j++) {
//                System.out.print(time[i][j] + " ");
//            }
//            System.out.println();
//        }
        int count = 1;
        int idx = 0;
        for (int i = 1; i < N; i++) {
            if (time[idx][1] <= time[i][0]) {
                count++;
                idx = i;
            }
        }

        bw.write(count + "");
        bw.close();
    }
}
