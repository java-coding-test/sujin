package boj.study.week17;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 분할 정복 문제
public class boj2_17829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int size = N;

        List<Integer> ans = new ArrayList<>();
        int[][] before = arr;
        int[][] after;
        int answer;
        while (true) {
//            for (int i = 0; i < before.length; i++) {
//                for (int j = 0; j < before[0].length; j++) {
//                    bw.write(before[i][j] + " ");
//                }
//                bw.write("\n");
//            }
            after = new int[size / 2][size / 2];
            for (int i = 0; i < size; i += 2) {
                for (int j = 0; j < size; j += 2) {
                    ans.add(before[i][j]);
                    ans.add(before[i + 1][j]);
                    ans.add(before[i][j + 1]);
                    ans.add(before[i + 1][j + 1]);
                    Collections.sort(ans);

                    after[i / 2][j / 2] = ans.get(2);
                    ans.clear();
                }
            }
            if ((size / 2) == 1) {
                answer = after[0][0];
                break;
            } else {
                before = after;
                size /= 2;
            }
        }
        bw.write(answer + "");
        bw.close();
    }
}
