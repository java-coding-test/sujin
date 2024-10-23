package boj.구현;

import java.io.*;

public class boj1_21734 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        for (char c : str.toCharArray()) {
            int sum = 0;
            int num = c;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            for (int i = 0; i < sum; i++) {
                bw.write(c);
            }
            bw.write("\n");
        }
        bw.close();
    }
}
