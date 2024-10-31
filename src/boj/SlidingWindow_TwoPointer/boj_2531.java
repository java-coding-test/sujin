package boj.SlidingWindow_TwoPointer;

import java.io.*;
import java.util.*;

public class boj_2531 {
    //    static ArrayList<Integer> kinds = new ArrayList<>();
    static Map<Integer, Integer> num = new HashMap<>();
    static int N, d, k, c;
    static int[] food;
    static int max = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        food = new int[N];

        for (int i = 0; i < N; i++) {
            food[i] = Integer.parseInt(br.readLine());
        }


        num.put(c, 1);
        for (int i = 0; i < k; i++) {
            num.put(food[i], num.getOrDefault(food[i], 0) + 1);
        }
        if (max < num.keySet().size()) {
            max = num.keySet().size();
        }


        for (int i = 1; i < N; i++) {
            removeMap(food[i - 1]);
            num.put(food[(i + k - 1) % N], num.getOrDefault(food[(i + k - 1) % N], 0) + 1);
            if (max < num.keySet().size()) max = num.keySet().size();
        }

        bw.write(max + "");
        bw.close();
    }

    private static void removeMap(int food) {
        if (num.get(food) == 1) {
            num.remove(food);
        } else {
            num.put(food, num.get(food) - 1);
        }
    }
}
