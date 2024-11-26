import java.io.*;
import java.util.StringTokenizer;

public class boj_11053 {
    static int N;
    static int[] arr;
    static int[] DP;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        DP = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            DP[i] = 1;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    DP[i] = Math.max(DP[i], DP[j] + 1);
                }
            }
            max = Math.max(max, DP[i]);
        }

        bw.write( max + "");
        bw.close();
    }
}
