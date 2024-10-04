package boj.step_by_step.back_tracking;

import java.io.*;

public class boj_9663 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int[] map;
    static int count;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        map = new int[N];

        dfs(0);
        bw.write(count + "");
        bw.close();
    }

    public static void dfs(int depth) {
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            map[depth] = i;
            if (possibility(depth)) {
                dfs(depth + 1);
            }
        }
    }

    public static boolean possibility(int col) {
        for (int i = 0; i < col; i++) {
            if (map[i] == map[col]) {
                return false;
            }
            if (Math.abs(map[i] - map[col]) == Math.abs(i - col)) {
                return false;
            }
        }
        return true;
    }
}


