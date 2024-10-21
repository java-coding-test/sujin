package boj.study.week25;

import java.io.*;
import java.util.*;

public class boj_7576 {
    static int N, M;
    static int[][] map;
    static Queue<Point_7576> queue = new LinkedList<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    queue.add(new Point_7576(j, i));
                }
            }
        }


        bfs();

        if (isAllVisited()) {
            bw.write(count - 1 + "");
        } else bw.write("-1");

        bw.close();
    }

    public static void bfs() {
        ArrayList<Queue<Point_7576>> queues = new ArrayList<>();

        queues.add(queue);

        while (!isAllQueueEmpty(queues)) {
            queue = queues.get(0);

            // 새로운 큐 만들어서 삽입 (빈큐)
            queues.add(new LinkedList<>());

            while (!queue.isEmpty()) {
                Point_7576 current = queue.poll();
                int x = current.x;
                int y = current.y;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                        if (map[ny][nx] == 0) {
                            map[ny][nx] = 1;
                            queues.get(1).add(new Point_7576(nx, ny));
                        }
                    }
                }
            }
            queues.remove(0);
            count++;
        }
    }

    public static boolean isAllQueueEmpty(ArrayList<Queue<Point_7576>> queues) {
        for (int i = 0; i < queues.size(); i++) {
            if (!queues.get(i).isEmpty()) return false;
        }
        return true;
    }

    public static boolean isAllVisited() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) return false;
            }
        }
        return true;
    }

    public static void printMap() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Point_7576 {
    int x, y;
    Point_7576(int x, int y) {
        this.x = x;
        this.y = y;
    }
}