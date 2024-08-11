package boj.study.week19;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

// 서로 다른 부분 문자열의 개수
public class boj1_11478 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                set.add(str.substring(i, j));
            }
        }

        bw.write(set.size() + "");
        bw.close();
    }
}
