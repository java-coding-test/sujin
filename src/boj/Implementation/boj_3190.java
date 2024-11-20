package boj.Implementation;

import java.io.*;
import java.util.*;

public class boj_3190 {
    static int N, K, L;
    static int[][] map;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static ArrayList<Move> moves = new ArrayList<>();
    static Deque<Point> snake = new LinkedList<>();
    static int answer = 0;
    static int moveIdx = 0;
    static int nextDirectionNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }


        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            int direction = 0;
            switch (c) {
                case 'D':
                    direction = 1;
                    break;
                case 'L':
                    direction = -1;
                    break;
            }
            moves.add(new Move(num, direction));
        }
        nextDirectionNum = moves.get(0).num;

        int x = 0, y = 0;
        int directionIdx = 0;


        while (true) {

            int nx = x + dx[directionIdx];
            int ny = y + dy[directionIdx];
            answer++;


            if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == -1) {
                break;
            }


            snake.addLast(new Point(nx, ny));
//            System.out.println(snake.size());
            if (map[nx][ny] == 1) {
                map[nx][ny] = 0;
            } else {
                System.out.println("1아닌블럭인데 " + map[nx][ny]);
                Point p = snake.pollFirst();
                map[p.x][p.y] = 0;
            }

//            if (map[nx][ny] == -1) {
//                break;
//            } else  map[nx][ny] = -1;
            map[nx][ny] = -1;

            x = nx; y = ny;

            if (moveIdx < moves.size()) {
                 if (nextDirectionNum == answer) {
                     directionIdx = (directionIdx + moves.get(moveIdx).direction + 4) % 4;
                     moveIdx++;
                     if (moveIdx < moves.size()) nextDirectionNum = moves.get(moveIdx).num;
                 }
            }
            System.out.println(answer + "초: nx = " + nx + ", ny = " + ny);

        }
        bw.write(answer + "");
        bw.close();
    }

    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Point o = (Point) obj;
            return o.x == x && o.y == y;
        }
    }

    static class Move {
        int num;
        int direction;
        Move(int num, int direction) {
            this.num = num;
            this.direction = direction;
        }
    }
}

