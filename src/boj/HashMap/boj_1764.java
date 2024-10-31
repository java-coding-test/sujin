package boj.HashMap;

import java.io.*;
import java.util.*;

/*
시간 초과 주의
해시맵은 조회 시 걸리는 시간 O(1)
for문 안이 n^2이 아닌지 확인하기
 */
public class boj_1764 {
    static int N, M;
    static Map<String, Integer> map = new HashMap<>();
    static ArrayList<String> notSeeAndLook = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), 1);
        }

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (map.getOrDefault(str, 0) != 0) {
                notSeeAndLook.add(str);
            }
        }

        Collections.sort(notSeeAndLook);
        int size = notSeeAndLook.size();
        bw.write(size + "\n");
        for (int i = 0; i < size; i++) {
            bw.write(notSeeAndLook.get(i) + "\n");
        }
        bw.close();
    }


}
