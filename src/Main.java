import java.io.*;
import java.util.*;

public class Main {
    static int T, K;
    static String W;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            W = br.readLine();
            K = Integer.parseInt(br.readLine());

            int sStart, sEnd;
            int lStart, lEnd;
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < W.length(); i++) {
                map.put(W.charAt(i), map.getOrDefault(W.charAt(i), 0) + 1);
                if (map.get(W.charAt(i)) == K) {

                }
            }


            for (int i = 0; i < W.length(); i++) {

            }

        }
    }
}
