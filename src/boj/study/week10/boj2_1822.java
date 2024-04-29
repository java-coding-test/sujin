package boj.study.week10;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2_1822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[] arrA = new int[A];
        int[] arrB = new int[B];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        int count = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for (int x : arrA) {
            if (!binarySearch(B, arrB, x)) {
                count++;
                result.add(x);
            }
        }
        bw.write(count + "\n");
        for (int x : result) {
            bw.write(x + " ");
        }
        bw.close();
    }

    public static boolean binarySearch(int length, int[] arr, int k) {
        int first = 0;
        int last = length - 1;
        int mid;
        while (first <= last) {
            mid = (first + last) / 2;
            if (arr[mid] == k) {
                return true;
            } else if (arr[mid] > k) {
                last = mid - 1;
            } else first = mid + 1;
        }
        return false;
    }
}
