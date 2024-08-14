package boj.study.week20;

import java.io.*;

public class boj2_3449 {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        char[][] arr = new char[2][];
        for (int i = 0; i < T; i++) {
            arr[0] = br.readLine().toCharArray();
            arr[1] = br.readLine().toCharArray();
            bw.write("Hamming distance is " + getDistance(arr) + ".\n");
        }
        bw.close();
    }

    static public int getDistance(char[][] arr) {
        int count = 0;
        for (int i = 0; i < arr[0].length; i++) {
            if (arr[0][i] != arr[1][i]) {
                count++;
            }
        }
        return count;
    }
}
