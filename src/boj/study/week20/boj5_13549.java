package boj.study.week20;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj5_13549 {
    static int min = Integer.MAX_VALUE;
    static int N, K;
    static boolean[] visited;
    static int MAX = 100000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[MAX + 1];
        bfs();
        bw.write(min + "");
        bw.close();
    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(N, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            visited[node.x] = true;
            if (node.x == K) min = Math.min(min, node.time);

            if (node.x * 2 <= MAX && !visited[node.x * 2]) queue.offer(new Node(node.x * 2, node.time));
            if (node.x + 1 <= MAX && !visited[node.x + 1]) queue.offer(new Node(node.x + 1, node.time + 1));
            if (node.x - 1 >= 0 && !visited[node.x - 1]) queue.offer(new Node(node.x - 1, node.time + 1));
        }
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
