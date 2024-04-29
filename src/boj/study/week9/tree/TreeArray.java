package boj.study.week9.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TreeArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] parent = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            parent[i] = i / 2;
        }
        System.out.println(Arrays.toString(parent));

    }
}
