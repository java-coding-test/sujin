package boj.study.week16;

import java.io.*;
import java.util.Arrays;

public class boj5_4779 {
    static int N;
    static char[] lineArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        StringBuilder sb;

        while ((str = br.readLine()) != null) {  // 입력이 멈추면 멈춤!
            N = Integer.parseInt(str);
            sb = new StringBuilder();

            int len = (int) Math.pow(3, N);
            lineArr = new char[len];
            Arrays.fill(lineArr, '-');

            divide(0, len);

            for (int i = 0; i < lineArr.length; i++) {
                sb.append(lineArr[i]);
            }
            bw.write(sb.toString());
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void divide(int start, int length) {
        if (length <= 1) {
            return;
        }
        int newLength = length / 3;

        for (int i = start + newLength; i < start + newLength * 2; i++) {
            lineArr[i] = ' ';
        }

        divide(start, newLength);
        divide(start + newLength * 2, newLength);
    }
}
