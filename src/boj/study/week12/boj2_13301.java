package boj.study.week12;

import java.io.*;
import java.math.BigInteger;

public class boj2_13301 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        BigInteger answer;
        if (N == 1) {
            answer = new BigInteger("4");
        } else if (N == 2) {
            answer = new BigInteger("6");
        }else if (N == 3) {
            answer = new BigInteger("10");
        }else {
            BigInteger[] arr = new BigInteger[N + 1];
            arr[1] = new BigInteger("1");
            arr[2] = new BigInteger("1");
            for (int i = 3; i <= N; i++) {
                arr[i] = arr[i - 2].add(arr[i - 1]);
            }

            answer = arr[N].multiply(new BigInteger("3"));
            answer = answer.add(arr[N - 1].multiply(new BigInteger("2")));
            answer = answer.add(arr[N - 2].multiply(new BigInteger("2")));
            answer = answer.add(arr[N - 3]);

        }
        bw.write(answer.toString());
        bw.close();
    }

}
