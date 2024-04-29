package boj.study.week10;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 시간 초과
public class boj2_1822_time_error {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arrA = new ArrayList<>();
        ArrayList<Integer> arrB = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            arrA.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            arrB.add(Integer.parseInt(st.nextToken()));
        }
        int count = 0;
        for (int i = 0; i < A; i++) {
            if (arrB.contains(arrA.get(i))) {
                arrA.set(i, 0);
                continue;
            }
            count++;
        }
        bw.write(count + "\n");
        for (int x : arrA) {
            if (x == 0) continue;
            bw.write(x + " ");
        }
        bw.close();
    }
}
