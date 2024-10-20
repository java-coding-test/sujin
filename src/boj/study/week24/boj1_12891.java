package boj.study.week24;

import java.io.*;
import java.util.*;

public class boj1_12891 {
    static int S, P;
    static int[] DNA = new int[4];  // 조건
    static int[] dnaString; // 문자열을 입력받은 배열

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        dnaString = new int[S];
//        dnaString = br.readLine().toCharArray();
        int count = 0;

        /*
         String으로 하기 싫어서 숫자로 변환
         A -> 0
         C -> 1
         G -> 2
         T -> 3
         */
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

        count = 0;

        for (int i = 0; i < P; i++) {
            sum[dnaString[i]]++;
        }

        if (canUse(sum)) count++;

        for (int i = 0; i < S - P; i++) {   // 시작포인터 변경 반복문 (인도우 슬라이딩)
            sum[dnaString[i]]--;
            sum[dnaString[i + P]]++;
            if (canUse(sum)) count++;
        }





        bw.write(count + "\n");
        bw.close();
    }

    // 조건 만족하는 지 확인하는 함수
    public static boolean canUse(int[] arr) {
        if (arr[0] >= DNA[0] && arr[1] >= DNA[1] && arr[2] >= DNA[2] && arr[3] >= DNA[3]) {
            return true;
        }
        return false;
    }
}
