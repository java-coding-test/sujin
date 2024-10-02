package boj.step_by_step.dp;

public class TopDownDP {
    static int[] dp = new int[100];

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = fib(n - 1) + fib(n - 2);
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("fibonacci(" + n + ") = " + fib(n));

    }
}
