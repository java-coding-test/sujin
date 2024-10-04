package boj.step_by_step.implementation;

import java.io.*;

public class boj_4673 {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] check = new boolean[10001];

        for (int i = 1; i < 10001; i++) {
            int n = d(i);

            if (n < 10001 && !check[n]) {
                check[n] = true;
            }
        }


        for (int i = 1; i < 10001; i++) {
            if (!check[i]) {
                bw.write(i + "\n");
            }
        }
        bw.close();
    }

    public static int d(int number) {
        int sum = number;

        while(number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
