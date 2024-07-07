package boj.study.week16;

import java.io.*;
import java.util.StringTokenizer;

class SegmentTree2 {
    long[] tree;
    int treeSize;

    public SegmentTree2(int arrSize) {
        int h = (int) Math.ceil(Math.log(arrSize) / Math.log(2));
        this.treeSize = (int) Math.pow(2, h + 1);
        tree = new long[treeSize];
    }

    public long init(int[] arr, int node, int start, int end) {
        if (start == end) {
            return tree[node] = arr[start];
        }

        return tree[node] =
                init(arr, node * 2, start, (start + end) / 2)
                        + init(arr, node * 2 + 1, (start + end) / 2 + 1, end);
    }

    public void update(int node, int start, int end, int idx, int diff) {
        if (idx < start || idx > end) return;
        if (start == end) {
            tree[node] = diff;
            return;
        }
        update(node * 2, start, (start + end) / 2, idx, diff);
        update(node * 2 + 1, (start + end) / 2 + 1, end, idx, diff);

        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    public long sum(int node, int start, int end, int left, int right) {
        if (left > end || right < start) return 0;
        if (left <= start && end <= right) return tree[node];

        return sum(node * 2, start, (start + end) / 2, left, right)
                + sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
    }

}

public class boj2_2268 {
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new long[N + 1];
        SegmentTree2 st2 = new SegmentTree2(N);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            if (st.nextToken().equals("0")) {
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                if (left < right) {
                    bw.write("" + st2.sum(1, 1, N, left, right) + "\n");
                } else {
                    bw.write("" + st2.sum(1, 1, N, right, left) + "\n");
                }
            } else {
                int idx = Integer.parseInt(st.nextToken());
                int diff = Integer.parseInt(st.nextToken());
                st2.update(1, 1, N, idx, diff);
            }
        }
        bw.close();
    }
}
