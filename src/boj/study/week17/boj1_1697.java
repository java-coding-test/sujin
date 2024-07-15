package boj.study.week17;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// bfs (DFS로 풀면 StackOverFlow 발생)
public class boj1_1697 {
    static int N, K;
    static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bw.write(bfs(N) + "");
        bw.flush();
        br.close();
        bw.close();
    }

    public static int bfs(int start) {
        // 가장 짧은 경로 (최솟값찾기 --> bfs 사용하기!)
        /*
         * bfs로 풀어야 하는 문제
         * 1. 최단 경로 또는 최소 단계 수를 요구하는 문제
         * 2. 특정 상태에서 다른 상태로 이동할 때, 모든 가능한 경로를 동일한 단계로 탐색해야 하는 문제
         */
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 1;
        int node;
        while (!queue.isEmpty()) {
            node = queue.poll();

            if (node == K) return visited[node] - 1;    // start 부터 1로 쳤기 때문

            if (node - 1 >= 0 && visited[node - 1] == 0){
                visited[node - 1] = visited[node] + 1;
                queue.add(node - 1);
            }

            if (node + 1 <= 100000 && visited[node + 1] == 0) {
                visited[node + 1] = visited[node] + 1;
                queue.add(node + 1);
            }

            if (node * 2 <= 100000 && visited[node * 2] == 0) {
                visited[node * 2] = visited[node] + 1;
                queue.add(node * 2);
            }
        }

        return -1;
    }
}
