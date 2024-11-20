package boj.BinarySearch;

import java.io.*;
import java.util.*;

public class boj_1654 {
    static int K, N;
    static int[] arr;
    static long MAX;
    static long MIN = 10001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            MAX = Math.max(arr[i], MAX);
//            MIN = Math.min(arr[i], MIN);
        }
        // 최대 값 539, 최소값 1
        bw.write(binarySearch() - 1 + "");
        bw.close();
    }

    private static long binarySearch() {
        long start = 1;
        long end = MAX + 1; // start = mid + 1이기 때문에 +1 해주어야 함

        // upper, lower bound 찾을 때는 등호 x
        while (start < end) {
            // 오버플로우 방지
            long mid = start + (end - start) / 2;
            long k = count(mid);

            if (k >= N) start = mid + 1;
            else end = mid;
        }
        return start; // 마지막에 바뀌지 않는걸로 예상되는 값
    }

    private static long count(long mid) {
        long count = 0;
        for (int size : arr) {
            count += size / mid;
        }

        return count;
    }
}
