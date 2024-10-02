package boj.step_by_step.dp;

public class BottomUpDP {
    static int[] dp = new int[100];
    public static int fib(int n) {
        if (n <= 1) return n;
        dp[0] = 0; dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 10;
        System.out.println("fibonacci(" + n + ") = " + fib(n));

    }

}
