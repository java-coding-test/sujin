package boj.study.week12;

import java.io.*;

public class boj1_14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        if (n == 1 || n == 3) {
            count = -1;
        } else if ((n % 5) % 2 != 0) {
            count += n / 5 - 1;
            n = n % 5 + 5;
            count += n / 2;
        } else{
            count += n / 5;
            n %= 5;
            count += n / 2;
        }
        bw.write(count + "");
        bw.close();
    }
}
