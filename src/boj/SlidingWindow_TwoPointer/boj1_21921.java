package boj.SlidingWindow_TwoPointer;

import java.io.*;
import java.util.*;

public class boj1_21921 {
    static int N, X;
    static int[] map;
    static int max = Integer.MIN_VALUE;
    static Map<Integer, Integer> maxMap = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        map = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int sum = 0;
        int count = 0;

        for (int i = 0; i < X; i++) {
            sum += map[i];
        }


        max = sum;
        maxMap.put(max, maxMap.getOrDefault(max, 0) + 1);

        for (int i = X; i < N; i++) {
            sum -= map[start++];
            sum += map[i];

            if (max <= sum) {
                max = sum;
                maxMap.put(max, maxMap.getOrDefault(max, 0) + 1);
            }
        }
        if (max == 0) {
            bw.write("SAD");
        } else {
            bw.write(max + "\n" + maxMap.get(max));
        }

        bw.close();
    }
}
