package boj.study.week24;

import java.io.*;
import java.util.*;

public class boj8_3273 {
    static int n;
    static int[] arr;
    static int x;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        x = Integer.parseInt(br.readLine());

        if (n == 1) {
            bw.write("0");
            bw.close();
            return;
        }

        Arrays.sort(arr);

        int start = 0;
        int end = n - 1;
        int sum = arr[start] + arr[end];
        int count = 0;

        while (start < end) {
            if (sum == x) {
                count++;
                start++;
                end--;
                sum = arr[start] + arr[end];
            } else if (sum < x) {
                sum -= arr[start];
                start++;
                sum += arr[start];
            } else {
                sum -= arr[end];
                end--;
                sum += arr[end];
            }
        }
        bw.write(count + "");
        bw.close();
    }
}
