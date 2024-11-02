package boj.Implementation;

import java.io.*;
import java.util.*;

public class boj_4920 {
    static int N;
    static int[][] map;

    static int[][][] blocks = {
            {{0,0}, {0,1}, {0,2}, {0,3}},
            {{0,0}, {1,0}, {2,0}, {3,0}},
            {{0,0}, {0,1}, {1,1}, {1,2}},
            {{0,0}, {1,0}, {1,-1}, {2,-1}},
            {{0,0}, {0,1}, {0,2}, {1,2}},
            {{0,0}, {1,0}, {2,0}, {2,-1}},
            {{0,0}, {1,0}, {1,1}, {1,2}},
            {{0,0}, {0,1}, {1,0}, {2,0}},
            {{0,0}, {0,1}, {0,2}, {1,1}},
            {{0,0}, {1,0}, {1,-1}, {2,0}},
            {{0,0}, {1,0}, {1,-1}, {1,1}},
            {{0,0}, {1,0}, {1,1}, {2,0}},
            {{0,0}, {1,0}, {0,1}, {1,1}}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int maxSum;
        int testCase = 1;

        while ((N = Integer.parseInt(br.readLine().trim())) != 0) {
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken().trim());
                }
            }

            maxSum = calMaxSum();
            sb.append(testCase++).append(". ").append(maxSum).append("\n");

        }
        bw.write(sb.toString());
        bw.close();
    }

    static int calMaxSum() {
        int max = Integer.MIN_VALUE;

        for (int idx = 0; idx < blocks.length; idx++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int sum = calSum(idx, i, j);
                    max = Math.max(max, sum);
                }
            }
        }
        return max;
    }
    static int calSum(int idx, int x, int y) {
        int sum = 0;
        for (int i = 0; i < blocks[idx].length; i++) {
            int nx = x + blocks[idx][i][0];
            int ny = y + blocks[idx][i][1];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                return Integer.MIN_VALUE;
            }

            sum += map[nx][ny];
        }

        return sum;
    }
}