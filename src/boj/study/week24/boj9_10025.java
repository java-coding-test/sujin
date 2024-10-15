package boj.study.week24;

import java.io.*;
import java.util.*;

public class boj9_10025 {
    static int N, K;
    static int[] arr = new int[1000005];
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int move = 2 * K + 1;

//        ArrayList<Point> points = new ArrayList<>();

        int maxNum = -1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
//            points.add(new Point(x, w));
            arr[x] = w;
            if (maxNum < x) maxNum = x;
        }

//        Collections.sort(points);

//        int size = points.get(0).x + 1;
//        arr = new int[size];
//
//        for (Point point : points) {
//            arr[point.x] = point.w;
//        }

        int sum = 0;

        if (maxNum < move) {
            for (int i = 0; i <= maxNum; i++) {
                sum += arr[i];
            }
            bw.write(sum + "");
            bw.close();
            return;
        }

        // 초기화
        for (int i = 0; i < move; i++) {
            sum += arr[i];
        }

        for (int i = K; i < maxNum - K; i++) {
            if (max < sum)  {
                max = sum;
            }
            sum -= arr[i - K];
            sum += arr[i + K + 1];
        }
        if (max < sum)  {
            max = sum;
        }

        bw.write(max + "");
        bw.close();
    }
}

//class Point implements Comparable<Point>{
//    int x, w;
//    public Point(int x, int w) {
//        this.x = x;
//        this.w = w;
//
//    }
//
//    @Override
//    public int compareTo(Point o) {
//        return o.x - this.x;
//    }
//}
