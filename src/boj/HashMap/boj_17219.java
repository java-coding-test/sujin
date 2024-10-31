package boj.HashMap;

import java.io.*;
import java.util.*;

public class boj_17219 {
    static int N, M;
    static Map<String, String> site = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String pw = st.nextToken();
            site.put(name, pw);
        }
        for (int i = 0; i < M; i++) {
            bw.write(site.get(br.readLine()) + "\n");
        }
        bw.close();
    }
}
