package boj.Sorting;

import java.io.*;
import java.util.*;

public class TopologicalSorting {
    // 노드의 개수 v, 간선의 개수 e
    static int v, e;

    // 모든 노드에 대한 진입차수를 저장하는 리스트
    static int[] inDegree = new int[100001];

    // 간선 정보를 담기 위한 연결 리스트 초기화
    static List<List<Integer>> graph = new ArrayList<>();
    static List<Integer> result = new ArrayList<>();
    // 위상 정렬 함수
    public static void topologySort() {
        Queue<Integer> q = new LinkedList<>();

        // 처음 시작할 때, 진입차수가 0인 노드를 큐에 삽입하기
        for (int i = 0; i <= v; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            result.add(now);

            // now 랑 연결된거 가져와서 간선 수 1개씩 줄이기
            // 줄인 후에 0이면 q에 삽입
            for (int i = 0; i < graph.get(now).size(); i++) {
                inDegree[graph.get(now).get(i)]--;
                if (inDegree[graph.get(now).get(i)] == 0) {
                    q.add(graph.get(now).get(i));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);

            inDegree[b]++;
        }

        topologySort();
        for (int i = 0; i < result.size(); i++) {
            bw.write(result.get(i) + " ");
        }

        bw.close();
    }
}
