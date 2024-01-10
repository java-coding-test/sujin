package boj.step_by_step.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_10811 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            arr = reverse(arr, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for (int x: arr) System.out.print(x + " ");
    }

    static int[] reverse(int[] arr, int a, int b) {
        int mid = (a + b) / 2;
        for (int i = a; i <= mid; i++) {

            int temp = arr[i - 1];
            arr[i - 1] = arr[b - 1];
            arr[b - 1] = temp;
            b--;
        }
        return arr;
    }
}
