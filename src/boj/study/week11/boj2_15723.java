package boj.study.week11;

import java.io.*;

// 15723번 n단 논법
public class boj2_15723 {
    public static int[][] edge;
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        edge = new int[26][26];


        String sb;
        int u, v;
        for (int i = 0; i < n; i++) {
            sb = br.readLine();
            u = (int)sb.charAt(0) - 97;
            v = (int)sb.charAt(sb.length() - 1) - 97;
            edge[u][v] = 1;
        }

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            sb = br.readLine();
            u = (int)sb.charAt(0) - 97;
            v = (int)sb.charAt(sb.length() - 1) - 97;
            bw.write(dfs(u, v) + "\n");
        }
        bw.close();
    }

    public static String dfs(int u, int v) {
        String answer = "F";
        if (edge[u][v] == 1) {
            answer = "T";
        } else {
            for (int i = 0; i < edge[0].length; i++) {
                if(edge[u][i] == 1) {
                    answer = dfs(i, v);
                }
            }
        }
        return answer;
    }
}
