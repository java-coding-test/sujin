package boj.study.week23;

import java.io.*;
import java.util.*;

/*
이분탐색을 꼭 배열안에서 숫자를 찾겠다라고 하지말고
조건을 만족하는 숫자를 찾는거에도 적용 가능함!!!
 */

public class boj4_2343 {
    static int N, M;
    static int[] lesson;
    static int sum;
    static int max = Integer.MIN_VALUE;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        lesson = new int[N];

        for (int i = 0; i < N; i++) {
            lesson[i] = Integer.parseInt(st.nextToken());
            sum += lesson[i];
            max = Math.max(max, lesson[i]);
        }

        bw.write(find(max, sum) + "");
        bw.close();
    }

    static int find(int start, int end) {
        if (start > end) return start;
        int mid = start + (end - start) / 2;
        int sumNum = 0;

        count = 1;
        for (int i = 0; i < N; i++) {
            sumNum += lesson[i];
            if (sumNum > mid) {
                sumNum = lesson[i];
                count++;
            }
        }
        if (count > M) {
            return find(mid + 1, end);
        } else {
            return find(start, mid - 1);
        }
    }
}
