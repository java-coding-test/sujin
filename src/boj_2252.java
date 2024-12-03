import java.util.*;
import java.io.*;

public class boj_2252 {
    static int N, M;
    static List<Integer> result = new ArrayList<>();
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        count = new int[N];

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph.get(a).add(b);
            count[b]++;
        }

        topologySort();

        for (int i = 0; i < result.size(); i++) {
            bw.write(result.get(i) + 1 + " ");
        }
        bw.close();
    }

    public static void topologySort() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (count[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            result.add(now);
            for (int i = 0; i < graph.get(now).size(); i++) {
                count[graph.get(now).get(i)]--;
                if (count[graph.get(now).get(i)] == 0) q.add(graph.get(now).get(i));
            }
        }
    }
}
