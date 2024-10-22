package boj.study.week25;

import java.io.*;
import java.util.*;

public class boj3_16928 {
    static int N, M;
    static int[] map = new int[101];
    static boolean[] visited = new boolean[101];
    static Map<Integer, Integer> ladders = new HashMap<>();
    static Map<Integer, Integer> snakes = new HashMap<>();
    static int count;

    static int[] dice = {1, 2, 3, 4, 5, 6};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());



        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ladders.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            snakes.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        bfs();
        bw.write(count + "");
        bw.close();
    }


    public static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(1, 0));
        visited[0] = true;
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int num = current.num;
            count = current.count;

            if (num == 100) {
                return;
            }

            for (int i = 0; i < 6; i++) {
                int next = num + dice[i];
                next = ladders.getOrDefault(next, next);
                next = snakes.getOrDefault(next, next);
                if (next <= 100 && !visited[next]) {
                    visited[next] = true;
                    queue.add(new Point(next, count + 1));
                }
            }
        }
    }
    static class Point {
        int num, count;
        public Point(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}

