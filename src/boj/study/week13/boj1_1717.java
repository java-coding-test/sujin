package boj.study.week13;

import java.io.*;
import java.util.StringTokenizer;

public class boj1_1717 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (k == 0) union(a, b);
            else bw.write(isSame(a, b));
        }
        bw.close();
    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return false;

        if (x <= y) parent[y] = x;
        else parent[x] = y;
        return true;
    }

    // 경로 압축을 해야 시간초과에 걸리지 않는다!
    static int find(int x) {
        if (parent[x] == x) return x;
        // 경로 압축 : 모든 노드를 최상위 노드에 연결하기
        return parent[x] = find(parent[x]);
    }

    static String isSame(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return "YES\n";
        else return "NO\n";
    }
}
