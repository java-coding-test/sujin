package boj.study.week11;

import java.io.*;
import java.util.*;

// 크리스마스 선물
public class boj1_14235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int a;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            if (a != 0) {
                for (int j = 0; j < a; j++) {
                    queue.offer(Integer.parseInt(st.nextToken()));
                }
            } else {
                if (queue.isEmpty()) {
                    bw.write("-1\n");
                } else{
                    bw.write(queue.poll() + "\n");
                }
            }

        }
        bw.close();
    }
}
