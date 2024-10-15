package boj.study.week24;

import java.io.*;
import java.util.*;

public class boj2_21736 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int startX, startY;

    static int count;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            count = 0;
            for (char c : br.readLine().toCharArray()) {
                switch (c) {
                    case '0':
                        map[i][count] = 0;
                        break;
                    case 'P':
                        map[i][count] = 1;
                        break;
                    case 'I':
                        map[i][count] = 2;
                        startX = i;
                        startY = count;
                        break;
                    case 'X':
                        map[i][count] = -1;
                        break;
                }
                count++;
            }
        }

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

        bfs();
        if (count == 0) bw.write("TT");
        else bw.write(count + "");
        bw.close();
    }

    public static void bfs() {
        Queue<Point_21736> queue = new LinkedList<>();

        queue.add(new Point_21736(startX, startY));

        count = 0;
        while(!queue.isEmpty()) {
            Point_21736 current = queue.poll();
            int x = current.x;
            int y = current.y;

            if (map[x][y] == 1) {
//                System.out.println("x=" + x + ", y=" + y);
                count++;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if (visited[nx][ny] || map[nx][ny] == -1) {
                    continue;
                }
                visited[nx][ny] = true;
                queue.add(new Point_21736(nx, ny));
            }
        }
    }
}

class Point_21736 {
    int x, y;
    public Point_21736(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
