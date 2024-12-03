package boj.DynamicProgramming;

import java.io.*;

public class boj_9251 {
    static Integer[][] dp;
    static String str1, str2;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        str2 = br.readLine();
        str1 = br.readLine();

        dp = new Integer[str1.length()][str2.length()];

        bw.write(LCS(str1.length() - 1, str2.length() - 1) + "");
        bw.close();

    }

    // Top-Down
    static int LCS(int x, int y) {
        if (x == -1 || y == -1) {
            return 0;
        }

        // 방문 전이라면 재귀, 방문한 적 있다면 값을 리턴
        if (dp[x][y] == null) {
            dp[x][y] = 0;

            if (str1.charAt(x) == str2.charAt(y)) {
                dp[x][y] = LCS(x - 1, y - 1) + 1;
            } else {
                dp[x][y] = Math.max(LCS(x - 1, y), LCS(x, y - 1));
            }
        }

        return dp[x][y];
    }
}
