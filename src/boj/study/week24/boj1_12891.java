package boj.study.week24;

import java.io.*;
import java.util.*;

public class boj1_12891 {
    static int S, P;
    static int[] DNA = new int[4];
    static int[] dnaString;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        dnaString = new int[S];
//        dnaString = br.readLine().toCharArray();
        int count = 0;
        for (char i : br.readLine().toCharArray()) {
            switch (i) {
                case 'A':
                    dnaString[count++] = 0;
                    break;
                case 'C':
                    dnaString[count++] = 1;
                    break;
                case 'G':
                    dnaString[count++] = 2;
                    break;
                case 'T':
                    dnaString[count++] = 3;
                    break;
            }
        }


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            DNA[i] = Integer.parseInt(st.nextToken());
        }

        int[] sum = new int[4];
        for (int i = 0; i < P; i++) {
            sum[dnaString[i]]++;
        }

        count = 0;
        for (int i = 0; i < S - P; i++) {
            if (canUse(sum)) count++;
            sum[dnaString[i]]--;
            sum[dnaString[i + P]]++;
        }
        if (canUse(sum)) count++;

        bw.write(count + "\n");
        bw.close();
    }

    public static boolean canUse(int[] arr) {
        if (arr[0] >= DNA[0] && arr[1] >= DNA[1] && arr[2] >= DNA[2] && arr[3] >= DNA[3]) {
            return true;
        }
        return false;
    }
}
