package boj.study.week21;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2_12851 {
    static int N, K;
    static int[] time = new int[100001];
    static int min = Integer.MAX_VALUE;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Arrays.fill(time, -1);
        if (N >= K) {
            bw.write((N - K) + "\n1");
            bw.close();
            return;
        }
        bfs();
        bw.write(min + "\n" + count);
        bw.close();
    }
    static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        q.add(N);
        time[N] = 0;

        while (!q.isEmpty()) {
            int temp = q.poll();

            if (min < time[temp]) return;
            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) next = temp + 1;
                else if (i == 1) next = temp - 1;
                else next = temp * 2;
                if (next > 100000 || next < 0) continue;
                if (next == K) {
                    if (time[temp] + 1 < min) {
                        min = time[temp] + 1;
                        count = 1;
                    } else if (time[temp] + 1 == min) {
                        count++;
                    }
                }
                if (time[next] == -1 || time[next] == time[temp] + 1) {
                    q.add(next);
                    time[next] = time[temp] + 1;
                }
            }

        }
    }
}
