package boj.study.week16;

import java.io.*;
import java.util.StringTokenizer;
class SegmentTree {
    long tree[];
    int treeSize;
    final int Q = 1000000007;   // 오버플로우 방지

    public SegmentTree(int arrSize) {
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
                        * init(arr, node * 2 + 1, (start + end) / 2 + 1, end) % Q;
    }

    public void update(int node, int start, int end, int idx, int diff) {
        if (idx < start || end < idx) return;
        if (start == end) {
            tree[node] = diff;
            return;
        }
        update(node * 2, start, (start + end) / 2, idx, diff);
        update(node * 2 + 1, (start + end) / 2 + 1, end, idx, diff);

        tree[node] = tree[node * 2] * tree[node * 2 + 1] % Q;
    }

    public long mul(int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return 1;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }

        return mul(node * 2, start, (start + end) / 2, left, right)
                * mul(node * 2 + 1, (start + end) / 2 + 1, end, left, right) % Q;
    }
}
public class boj1_11505 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        SegmentTree seg = new SegmentTree(N);
        seg.init(arr, 1, 1, N);
        M = M + K;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            if (f == 1) {
                int idx = Integer.parseInt(st.nextToken());
                int diff = Integer.parseInt(st.nextToken());
                seg.update(1, 1, N, idx, diff);
            } else {
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                bw.write("" + seg.mul(1, 1, N, left, right) + "\n");
            }
        }
        bw.close();
    }
}
