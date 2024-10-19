package boj.study.week24;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class lcm_gcd {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        lcm_gcd lcm = new lcm_gcd();
        bw.write(lcm.gcd(48, 18) + "\n");
        bw.write(lcm.lcm(48, 18) + "");
        bw.close();

    }
    public int gcd(int m, int n) {
        int r = m % n;
        while (r != 0) {
            m = n;
            n = r;
            r = m % n;
        }
        return n;
    }

    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
