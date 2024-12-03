import java.io.*;
import java.util.*;

public class Main_2 {
    static int N, M;
    static int[] ingredientCount;

    static List<List<Edge>> edges = new ArrayList<>();
    static Map<Integer, Integer> count = new HashMap<>();
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            edges.add(new ArrayList<>());
        }
        ingredientCount = new int[N];

        M = Integer.parseInt(br.readLine());



        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.get(b).add(new Edge(a, c));
            ingredientCount[a]++;
        }

        for (int i = 0; i < N; i++) {
            if (ingredientCount[i] == 0) {
                q.add(i);
            }
        }


        while (!q.isEmpty()) {
            int now = q.poll();
//            int num = edges.get(now).ge
        }

    }
    static class Edge {
        int y, k;
        public Edge(int y, int k) {
            this.y = y;
            this.k = k;
        }
    }
}
