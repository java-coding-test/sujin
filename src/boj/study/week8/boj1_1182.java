package boj.study.week8;

import java.io.*;
import java.util.StringTokenizer;

public class boj1_1182 {
    static int N;
    static int S;
    static int[] arr;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0, 0);
        bw.write(answer + "");
        bw.close();
    }

    public static void dfs(int count, int sum, int depth) {
        if (count != 0 && sum == S) {
            answer++;
//            System.out.println(answer);
            count = 0;
        }

        if (depth == N) {
            return;
        }
//        System.out.println("adfs(" + (count + 1) + ", " + (sum + arr[depth]) + ", " + (depth + 1) + ")");
        dfs(count + 1, sum + arr[depth], depth + 1);

//        System.out.println("bdfs(" + count + ", " + sum + ", " + depth + ")");
        dfs(count, sum, depth + 1);
    }
}
