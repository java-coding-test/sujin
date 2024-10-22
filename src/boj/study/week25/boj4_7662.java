package boj.study.week25;

import java.io.*;
import java.util.*;

public class boj4_7662 {
    static int T, K;
    static String exp;
    static int num;
    static Map<Integer, Integer> map;
    static PriorityQueue<Integer> maxQ;
    static PriorityQueue<Integer> minQ;
    static int min, max;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            maxQ = new PriorityQueue<>(Collections.reverseOrder());
            minQ = new PriorityQueue<>();
            map = new HashMap<>();
            K = Integer.parseInt(br.readLine());
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                exp = st.nextToken();
                num = Integer.parseInt(st.nextToken());
                if (exp.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                    maxQ.add(num);
                    minQ.add(num);
                } else {
                    if (!map.isEmpty()) {
                        if (num != -1) {
                            removeMax();
                        } else {
                            removeMin();
                        }
                    }
                }
            }
            if (map.isEmpty()) {
                bw.write("EMPTY\n");
            } else {
                max = getNum(maxQ);
                min = getNum(minQ);
                bw.write(max + " " + min + "\n");
            }
        }

        bw.close();
    }

    public static int getNum(Queue<Integer> q) {
        while (!q.isEmpty()) {
            int num = q.poll();
            if (map.containsKey(num)) {
                return num;
            }
        }
        return 0;
    }


    public static void removeMax() {
        while (!maxQ.isEmpty()) {
            num = maxQ.poll();
            if (map.containsKey(num)) {
                removeMap(num);
                return;
            }
        }
    }

    public static void removeMin() {
        while (!minQ.isEmpty()) {
            num = minQ.poll();
            if (map.containsKey(num)) {
                removeMap(num);
                return;
            }
        }
    }

    public static void removeMap(int num) {
        if (map.get(num) == 1) map.remove(num);
        else map.put(num, map.get(num) - 1);
    }
}
