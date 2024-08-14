package boj.study.week20;

import java.io.*;
import java.util.*;

public class boj3_11723 {
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String ex;
        Set<Integer> S = new HashSet<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            ex = st.nextToken();
            int num;
            switch (ex) {
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    S.add(num);
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    S.remove(num);
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    if (S.contains(num)) bw.write("1\n");
                    else bw.write("0\n");
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    if (S.contains(num)) S.remove(num);
                    else S.add(num);
                    break;
                case "all":
                    S = all();
                    break;
                case "empty":
                    S = new HashSet<>();
                    break;
                default: break;
            }
        }
        bw.close();
    }
    public static Set<Integer> all() {
        Set<Integer> arr = new HashSet<>();
        for (int i = 1; i <= 20; i++) {
            arr.add(i);
        }
        return arr;
    }
}
