package boj.study.week15;

import java.io.*;
import java.util.StringTokenizer;

public class boj4_24060 {
    static int[] sorted;
    static int count;
    static int K;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        sorted = new int[N];
        count = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(arr, 0, arr.length - 1);

        if (count < K) {
            bw.write("-1");
        }
        bw.close();
    }

    public static void merge_sort(int[] arr, int l, int r) throws IOException{
        int m;
        if (l < r) {
            m = (l + r) / 2;
            merge_sort(arr, l, m);
            merge_sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) throws IOException{
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                sorted[k++] = arr[i++];
                if (++count == K) {
                    bw.write(sorted[k - 1] + "");
                    return;
                }
            } else{
                sorted[k++] = arr[j++];
                if (++count == K) {
                    bw.write(sorted[k - 1] + "");
                    return;
                }
            }
        }

        // 남은 값들 일괄 복사
        if (i > mid) {
            for (int l = j; l <= right; l++) {
                sorted[k++] = arr[l];
                if (++count == K) {
                    bw.write(sorted[k - 1] + "");
                    return;
                }
            }
        }
        else {
            for (int l = i; l <= mid; l++) {
                sorted[k++] = arr[l];
                if (++count == K) {
                    bw.write(sorted[k - 1] + "");
                    return;
                }
            }
        }

        // 배열 sorted[]의 값들을 원래의 배열로 복사
        for (int l = left; l <= right; l++) {
            arr[l] = sorted[l];
        }
    }
}
