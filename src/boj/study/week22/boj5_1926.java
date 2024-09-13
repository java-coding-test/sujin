package boj.study.week22;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj5_1926 {
    static int n,m;
    static int[][] painting;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static int count, area, max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        painting = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                painting[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][m];

        Queue<Pair_1926> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (painting[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                visited[i][j] = true;
                count++;
                queue.add(new Pair_1926(i, j));
                area = 0;
                while(!queue.isEmpty()) {
                    Pair_1926 pair = queue.poll();
                    area++;
                    for (int k = 0; k < 4; k++) {
                        int nx = pair.x + dx[k];
                        int ny = pair.y + dy[k];
                        if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny]) {
                            continue;
                        }
                        if (painting[nx][ny] == 1) {
                            queue.add(new Pair_1926(nx, ny));
                            visited[nx][ny] = true;
                        }
                    }
                }
                if (area > max) {
                    max = area;
                }
            }
        }
        bw.write(count + "\n");
        bw.write(max + "");
        bw.flush();
        bw.close();
    }
}
class Pair_1926 {
    int x;
    int y;
    public Pair_1926(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
