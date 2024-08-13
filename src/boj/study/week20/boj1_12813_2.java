package boj.study.week20;

import java.io.*;

public class boj1_12813_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String binaryA = br.readLine();
        String binaryB = br.readLine();

        int A = Integer.parseInt(binaryA, 2);
        int B = Integer.parseInt(binaryB, 2);

        bw.write(String.format("%10s", Integer.toBinaryString(A & B)).replace(' ', '0') + "\n");
        bw.write(String.format("%10s", Integer.toBinaryString(A | B)).replace(' ', '0') + "\n");
        bw.write(String.format("%10s", Integer.toBinaryString(A ^ B)).replace(' ', '0') + "\n");
        bw.write(String.format("%10s", Integer.toBinaryString(~A & 0x3FF)).replace(' ', '0') + "\n");
        bw.write(String.format("%10s", Integer.toBinaryString(~B & 0x3FF)).replace(' ', '0') + "\n");
        bw.close();
    }
}

