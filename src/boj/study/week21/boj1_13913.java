package boj.study.week21;

import java.io.*;
import java.util.*;

public class boj1_13913 {
    static int N, K;
    static int MAX = 100000;
    static int[] root = new int[MAX + 1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Arrays.fill(root, -1);


        bw.write(bfs() + "\n");
        bw.write(printRoot());
        bw.close();
    }
    static int bfs() {
        if (N >= K) {
            for (int i = N - 1; i >= K; i--) {
                root[i] = i + 1;
            }
            return N - K;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(N, 0));
        root[N] = N;
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp.x == K) {
                return temp.time;
            }
            if (temp.x + 1 <= MAX && root[temp.x + 1] == -1) {
                q.offer(new Node(temp.x + 1, temp.time + 1));
                root[temp.x + 1] = temp.x;
            }
            if (temp.x - 1 >= 0 && root[temp.x - 1] == -1) {
                q.offer(new Node(temp.x - 1, temp.time + 1));
                root[temp.x - 1] = temp.x;
            }
            if (temp.x * 2 <= MAX && root[temp.x * 2] == -1) {
                q.offer(new Node(temp.x * 2, temp.time + 1));
                root[temp.x * 2] = temp.x;
            }
        }
        return -1;
    }

    static String printRoot() {
        StringBuilder sb = new StringBuilder();
        for (int i = K; i != N; i = root[i]) {
            sb.insert(0, i + " ");
        }
        sb.insert(0, N + " ");
        return sb.toString();
    }

    public static class Node {
        int x;
        int time;
        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}
