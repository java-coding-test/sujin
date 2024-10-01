package boj.step_by_step.implementation;

import java.io.*;

public class boj_2231 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        int result = 0;
        int sum, number;
        for (int i = 0; i < N; i++) {
            number = i;
            sum = i;
            while (number != 0) {
                sum += number % 10;
                number /= 10;
            }

            if (sum == N) {
                result = i;
                break;
            }

        }
        bw.write(result + "");
        bw.close();
    }
}
