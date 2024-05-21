package boj.study.week12;

import java.io.*;
import java.util.*;

public class boj4_18352 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        List<Integer>[] edges = new List[N + 1];
        for (int i = 1; i < N + 1; i++) {
            edges[i] = new ArrayList<>();
        }
        int u, v;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            edges[u].add(v);
        }
        int[] dist = new int[N + 1];

        Arrays.fill(dist, -1);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(X);
        dist[X] = 0;

        List<Integer> answer = new ArrayList<>();

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (dist[cur] > K) break;
            if (dist[cur] == K) {
                answer.add(cur);
            }
            for (int next : edges[cur]) {
                if (dist[next] != -1) continue;
                dist[next] = dist[cur] + 1;
                q.add(next);
            }
        }

        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        for (int cur : answer) {
            sb.append(cur).append("\n");
        }
        System.out.println(answer.isEmpty() ? -1 : sb);
    }
}
