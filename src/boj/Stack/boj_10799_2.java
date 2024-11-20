package boj.Stack;

import java.io.*;

public class boj_10799_2 {
    static int pNum;
    static int count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        boolean flag = false;
        for (char c : str.toCharArray()) {
            if (c == '(') {
                pNum += 1;
                flag = false;
            } else {
                if (flag) {
                    count += 1;
                    pNum -= 1;
                } else {
                    pNum -= 1;
                    count += pNum;
                    flag = true;
                }
            }
        }
        bw.write(count + "");
        bw.close();
    }
}
