package boj.study.week23;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 최단 경로 문제는

public class boj3_4485_dfs_시간초과 {
    static int N;
    static int[][] map;

    static int min;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static boolean[][] visited;
    static int[][] dp;
    static int count;

    static int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        while (!(str = br.readLine()).equals("0")) {
            count++;

            N = Integer.parseInt(str);

            map = new int[N][N];
            visited = new boolean[N][N];
            dp = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(dp[i], 200_000);
            }


            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

//            System.out.println("------map------");
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N; j++) {
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }

            min = MAX;
//            System.out.println("count : " + count);
            visited[0][0] = true;
            dfs(new Point_4485_dfs(0, 0), map[0][0]);

            bw.write("Problem " + count + ": " + min + "\n");
        }
        bw.close();
    }
    static void dfs(Point_4485_dfs current, int cost) {
        if (current.x == N - 1 && current.y == N - 1) {
            min = Math.min(min, cost);
//            System.out.println("이건 잘 구해졌나?" + min);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = current.x + dx[i];
            int ny = current.y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                int newCost = cost + map[nx][ny];
                if (newCost > dp[nx][ny]) continue;
                visited[nx][ny] = true;
                dp[nx][ny] = newCost;

                dfs(new Point_4485_dfs(nx, ny), newCost);
                visited[nx][ny] = false;
            }
        }
    }

}

class Point_4485_dfs {
    int x, y;
    public Point_4485_dfs(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
