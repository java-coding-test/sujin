package boj.study.week19;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class boj2_1620 {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String name = "";
        Map<Integer, String> numMap = new HashMap<>();
        Map<String, Integer> nameMap = new HashMap<>();

        for (int i = 1; i < N + 1; i++) {
            name = br.readLine();
            numMap.put(i, name);
            nameMap.put(name, i);
        }

        for (int i = 0; i < M; i++) {
            name = br.readLine();
            if (nameMap.containsKey(name)) {
                bw.write(nameMap.get(name) + "\n");
            } else {
                bw.write(numMap.get(Integer.parseInt(name)) + "\n");
            }
        }
        bw.close();
    }
}
