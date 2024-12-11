import java.io.*;
import java.util.*;

public class boj_11055 {
    static int N;
    static int[] DP, I;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        DP = new int[N + 1];
        I = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            I[i] = Integer.parseInt(st.nextToken());
        }

        DP[1] = I[1];

        for (int i = 1; i <= N; i++) {
            DP[i] = I[i];
            for (int j = 1; j < i; j++) {
                if (I[i] > I[j]) {
                    DP[i] = Math.max(DP[j] + I[i], DP[i]);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i : DP) {
            max = Math.max(i, max);
        }

        bw.write(max + "\n");
        bw.close();
    }
}
