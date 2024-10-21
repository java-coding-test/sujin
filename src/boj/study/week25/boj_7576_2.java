package boj.study.week25;

import java.io.*;
import java.util.*;

/*
날짜 계산해야 함
클래스에 날짜 들어가서 메모리 효율성이 떨어짐

but 가독성이 좋음
 */
public class boj_7576_2 {
    static int N, M;
    static int[][] map;
    static Queue<Tomato> queue = new LinkedList<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int maxDay;

    public static void main(String[] args) throws IOException{
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
                    queue.add(new Tomato(j, i, 0));
                }
            }
        }

        bfs();
        if (isAllVisited()) {
            bw.write(maxDay + "");
        } else bw.write("-1");
        bw.close();
    }

    public static void bfs() {
        while(!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            int x = tomato.x;
            int y = tomato.y;
            maxDay = tomato.days;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (map[ny][nx] == 0) {
                        map[ny][nx] = 1;
                        queue.add(new Tomato(nx, ny, maxDay + 1));
                    }
                }
            }
        }
    }

    public static boolean isAllVisited() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) return false;
            }
        }
        return true;
    }
}

class Tomato {
    int x, y, days;
    public Tomato(int x, int y, int days) {
        this.x = x;
        this.y = y;
        this.days = days;
    }
}
