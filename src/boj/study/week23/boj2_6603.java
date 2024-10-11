package boj.study.week23;

import java.io.*;
import java.util.*;

public class boj2_6603 {
    static int K;
    static int[] num;
    static ArrayList<Integer> answer = new ArrayList<>();
    static boolean[] visited;

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        while (true) {
            str = br.readLine();
            if (str.equals("0")) {
                bw.write("\n");
                break;
            }

            StringTokenizer st = new StringTokenizer(str);
            K = Integer.parseInt(st.nextToken());

            visited = new boolean[K];

            num = new int[K];

            for (int i = 0; i < K; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(num);

            dfs(0, 0);
            bw.write("\n");
        }
        bw.close();
    }

    static void dfs(int count, int depth) throws IOException{
        if (depth == 6) {
            for (int val: answer) {
                bw.write(val + " ");
            }
            bw.write("\n");
            return;
        }

        // count 로 시작하는 이유 순서 변경되는 것은 고려하지 않기 위해
        for (int i = count; i < K; i++) {
            if (answer.contains(num[i])) {
                continue;
            }
            answer.add(num[i]);
            dfs(i + 1, depth + 1);
            answer.remove(answer.size() - 1);
        }
    }
}

