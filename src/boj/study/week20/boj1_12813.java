package boj.study.week20;

import java.io.*;

public class boj1_12813 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] A = br.readLine().toCharArray();
        char[] B = br.readLine().toCharArray();

        for (int i = 0; i < A.length; i++) {
            if (A[i] == '1' & B[i] == '1') {
                bw.write("1");
            } else bw.write("0");
        }
        bw.write("\n");

        for (int i = 0; i < A.length; i++) {
            if (A[i] == '1' | B[i] == '1') {
                bw.write("1");
            } else bw.write("0");
        }
        bw.write("\n");

        for (int i = 0; i < A.length; i++) {
            if (A[i] == '1' & B[i] == '0' || A[i] == '0' & B[i] == '1') {
                bw.write("1");
            } else bw.write("0");
        }
        bw.write("\n");

        for (int i = 0; i < A.length; i++) {
            if (A[i] == '0'){
                bw.write("1");
            } else bw.write("0");
        }
        bw.write("\n");

        for (int i = 0; i < A.length; i++) {
            if (B[i] == '0') {
                bw.write("1");
            } else bw.write("0");
        }

        bw.close();
    }
}
