package boj.step_by_step.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int maxNum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (maxNum < arr[i]) maxNum = arr[i];
        }
        float sum = 0;
        for (int i = 0; i < N; i++) {
            sum += (float) arr[i] / maxNum * 100;
        }
        System.out.println(sum / N);
    }
}