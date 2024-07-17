package boj.study.week17;

import java.io.*;
import java.util.StringTokenizer;

public class boj5_14889 {
    static int N;
    static int[][] ability;
    static int total = 0;
    static int diff = Integer.MAX_VALUE;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        ability = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N];

        dfs(0, 0);

        bw.write(diff + "");
        bw.flush();
        br.close();
        bw.close();
    }
    static public void dfs(int idx, int level) {
        if (level == N / 2) {
            calculateDifference();
            return;
        }


        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, level + 1);
                visited[i] = false;
            }
        }
    }

    static void calculateDifference() {
        int startTeam = 0;
        int linkTeam = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    startTeam += ability[i][j] + ability[j][i];
                } else if (!visited[i] && !visited[j]) {
                    linkTeam += ability[i][j] + ability[j][i];
                }
            }
        }
        int currentDiff = Math.abs(startTeam - linkTeam);
        diff = Math.min(diff, currentDiff);
    }
}
