package boj.study.week25;

import java.io.*;
/*
b 와 a를 교환해서 a가 연속되도록 만드는데 최소 교환의 수를 구하시오
a의 개수를 부분 문자열로 해서, b가 가장 적게 있을 때의 b의 개수를 구하기
 */

public class boj1_1522 {
    static String str;
    static int min = 1001;
    static int count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        // a의 개수 구하기 = 부분 문자열의 길이 구하기
        int countA = countChar(str, 'a');

        // 모든 부분 문자열을 구해서 b의 개수를 세기
        for (int i = 0; i < str.length(); i++) {
//            System.out.println("[i]: " + i);
            int countLocal = 0;
            int countB = 0;
            while (countLocal != countA) {
                if (str.charAt((i + countLocal) % str.length()) != 'a') {
                    countB++;
//                    System.out.print(countB);
                }
                countLocal++;
//                System.out.print(countLocal + " ");
            }
//            StringBuilder subString;
//            if (i + countA > str.length()) {
//                countFront = (i + countA) % str.length();
//                subString = new StringBuilder(str.substring(i)).append(str, 0, countFront);
//            } else {
//                subString = new StringBuilder(str.substring(i, i + countA));
//            }

            // b의 개수가 작으면 min값 업데이트
//            min = Math.min(min, countChar(subString.toString(), 'b'));
//            System.out.println(countB);
            min = Math.min(min, countB);
        }

        bw.write(min + "");
        bw.close();

    }

    // str에서 char의 개수를 세는 함수
    public static int countChar(String str, char c) {
        count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }
}
