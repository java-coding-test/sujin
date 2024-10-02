package boj.step_by_step.dp;

import java.util.Arrays;

public class LCS {
    public static String lcs(String A, String B) {
        int m = A.length(), n = B.length();
        int[][] opt = new int[m + 1][n + 1];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (A.charAt(i) == B.charAt(j)) {
                    opt[i][j] = opt[i + 1][j + 1] + 1;
                } else {
                    opt[i][j] = Math.max(opt[i + 1][j], opt[i][j + 1]);
                }
            }
        }

        for (int i = 0; i < opt.length; i++) {
            System.out.println(" 생성된 2차열 배열 :: " + Arrays.toString(opt[i]));
        }

        int i = 0, j = 0;

        StringBuilder sb = new StringBuilder();

        while (i < m && j < n) {
            if (A.charAt(i) == B.charAt(j)) {
                sb.append(A.charAt(i++));
                j++;
            } else if (opt[i + 1][j] >= opt[i][j + 1]) {
                i++;
            } else {
                j++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(lcs("banana", "vbankn"));
    }
}
