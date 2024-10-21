package boj.study.week25;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 투 포인터
public class boj2_2470 {
    static int min = Integer.MAX_VALUE;
    static int N;
    static int[] liquids;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        liquids = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            liquids[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(liquids);

        int start = 0;
        int end = liquids.length - 1;
        int answerStart = start;
        int answerEnd = end;

        if (liquids.length == 2) {
            bw.write(liquids[start] + " " + liquids[end] + "\n");
            bw.close();
            return;
        }

        while (start < end) {
            int answer = liquids[start] + liquids[end];
            if (Math.abs(answer) < min) {
                min = Math.abs(answer);
                answerStart = start;
                answerEnd = end;
            }

            if (answer > 0) {
                end--;
            } else if (answer < 0) {
                start++;
            } else {
                bw.write(liquids[start] + " " + liquids[end] + "\n");
                bw.close();
                return;
            }
        }

        bw.write(liquids[answerStart] + " " + liquids[answerEnd] + "\n");
        bw.close();
    }
}
