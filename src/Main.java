import java.io.*;
import java.util.*;

public class Main {
    static int N, K, L;
    static ArrayList<Point> arr = new ArrayList<Point>();
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<Integer> num = new ArrayList<>();
    static Queue<String> q = new LinkedList<>();

    static int count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
        }



        L = Integer.parseInt(br.readLine());

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            num.add(Integer.parseInt(st.nextToken()));
            q.offer(st.nextToken());
        }

    }


    static private void go(int x, int y, String direction) {
        int idx = 0;
        count = 0;
        while (x < N && y < N && x >= 0 && y >= 0 && arr.contains(new Point(x, y))){
            idx++;

        }
    }

    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point other = (Point) o;
            return this.x == other.x && this.y == other.y;
        }
    }
}

