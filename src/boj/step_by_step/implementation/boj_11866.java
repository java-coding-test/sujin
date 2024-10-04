package boj.step_by_step.implementation;

import java.io.*;
import java.util.*;

public class boj_11866 {
    static int N, K;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i < N + 1; i++) {
            arr.add(i);
        }
        ArrayList<Integer> num = new ArrayList<>();
        int count = K - 1;
        while (true) {
            int remove = arr.get(count);

            arr.remove(count);
            num.add(remove);
            if (arr.isEmpty()) break;

            count = ((count + K - 1) % arr.size());
        }
        bw.write("<");
        for (int i = 0; i < N - 1; i++) {
            bw.write(num.get(i) + ", ");
        }
        bw.write(num.get(N - 1) + ">");

        bw.close();
    }
}
