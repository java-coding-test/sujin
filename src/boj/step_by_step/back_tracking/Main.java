package boj.step_by_step.back_tracking;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int min = Integer.MAX_VALUE;

    static int N, M;
    static int[][] city;

    static int total;
    static int cost;

    static ArrayList<Point> chicken = new ArrayList<>();
    static ArrayList<Point> house = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        city = new int[N][N];


        house = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                city[i][j] = num;
                if (num == 1) {
                    house.add(new Point(j, i));
                } else if (num == 2) {
                    chicken.add(new Point(j, i));
                }
            }
        }
        visited = new boolean[chicken.size()];

        dfs(0);
        bw.write(min + "");
        bw.close();

    }
    public static void dfs(int depth) {
        if (depth == M) {
//            System.out.println("[total] : " + total);
            if (min > total) {
                min = total;
                return;
            }
        }
        Point currentChicken, currentHouse;
        for (int i = 0; i < chicken.size(); i++) {
            currentChicken = chicken.get(i);
//            System.out.println("---- chicken-----\n("+ currentChicken.x + ", " + currentChicken.y + ")");
            int minCost = Integer.MAX_VALUE;

            for (int j = 0; j < house.size(); j++) {
                currentHouse = house.get(j);
                cost = Math.abs(currentChicken.x - currentHouse.x) + Math.abs(currentChicken.y - currentHouse.y);
                if (minCost > cost) {
                    minCost = cost;
                };
            }

            total += minCost;
//            System.out.println("[cost] (" + currentHouse.x + ", " + currentHouse.y + ") = " + cost);

            if (total <= min && !visited[i]) {
                visited[i] = true;
                dfs(depth + 1);
                visited[i] = false;
            }
            total -= minCost;
        }
    }
}
class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
