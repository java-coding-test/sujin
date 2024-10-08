package boj.study.week23;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1_15654 {
    static int N, M;
    static int[] num;

    static ArrayList<Integer> answer;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];
        answer = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);
        dfs(0);

        bw.close();

    }

    public static void dfs(int depth) throws IOException{
        if (answer.size() == M) {
            for (int i = 0; i < M; i++) {
                bw.write(answer.get(i) + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (answer.contains(num[i])) {
                continue;
            }
            answer.add(num[i]);
            dfs(depth + 1);
            answer.remove(answer.size() -1);
        }
    }
}
