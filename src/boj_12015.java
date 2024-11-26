import java.io.*;
import java.util.*;

// 증가하는 부분 수열 구하기
public class boj_12015 {
    static int N;
    static int[] arr;
    static int[] result;
    static int size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        result = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        result[0] = arr[0];
        size = 1;
        for (int i = 1; i < N; i++) {
            if (arr[i] > result[size - 1]) {
                result[size++] = arr[i];
            } else {
                exchange(arr[i]);
            }
        }

        bw.write(size + "");
        bw.close();
    }

    static void exchange(int key) {
        int start = 0;
        int end = size;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (result[mid] >= key) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        result[start] = key;
    }
}
