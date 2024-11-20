import java.util.*;
import java.io.*;

public class boj_2467 {
    static int N;
    static long[] liq;
    static long MIN = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        liq = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            liq[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(liq);
        int start = 0;
        int end = N - 1;
        long liq1 = 0;
        long liq2 = 0;

        while (start < end) {
            long result = liq[start] + liq[end];
//            System.out.println(result);
            if (result == 0) {
                bw.write(liq[start] + " " + liq[end]);
                bw.close();
                return;
            } else if (result > 0) {
                if (MIN > Math.abs(result)) {
                    MIN = Math.abs(result);
                    liq1 = liq[start];
                    liq2 = liq[end];
                }
                end--;
            } else {
                if (MIN > Math.abs(result)) {
                    MIN = Math.abs(result);
                    liq1 = liq[start];
                    liq2 = liq[end];
                }
                start++;
            }
//            System.out.println(liq1 + " " + liq2);
        }
        bw.write(liq1 + " " + liq2);
        bw.close();
    }
}
