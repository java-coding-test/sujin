package boj.study.week18;

import java.io.*;
import java.util.PriorityQueue;

public class boj3_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(br.readLine());

            if (val == 0) {
                if (queue.isEmpty()) bw.write("0\n");
                else bw.write(queue.poll() + "\n");
            }
            else queue.add(val);
        }
        bw.close();
        br.close();
    }
}
