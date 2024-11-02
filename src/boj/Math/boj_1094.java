package boj.Math;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class boj_1094 {
    static int X;
    static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        X = Integer.parseInt(br.readLine());
        int sum = 64;
        int min = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(64);
        while (sum != X) {
            min = pq.poll();
            sum -= min;

            min /= 2;


            if (sum + min >= X) {
                sum += min;
                pq.add(min);
            } else {
                pq.add(min);
                pq.add(min);
                sum += 2 * min;
            }
        }
        bw.write(pq.size() + "\n");
        bw.close();

    }
}
