package boj.step_by_step.dfs;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_2606 {
    static int N, E;
    static ArrayList<Integer>[] map;
    static boolean[] visited;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        map = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];

        StringTokenizer st;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            map[v].add(w);
            map[w].add(v);
        }

        dfs();
        bw.write((count) + "");
        bw.close();
    }

    public static void dfs() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        visited[1] = true;

        while (!stack.isEmpty()) {
            int current = stack.pop();
            for (int v : map[current]) {
                if (!visited[v]) {
                    stack.push(v);
                    visited[v] = true;
                    count++;
                }
            }
        }
    }
}
