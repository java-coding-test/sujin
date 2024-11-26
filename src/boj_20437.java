import java.io.*;
import java.util.*;

public class boj_20437 {
    static int T, K;
    static String W;
    static int min;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            W = br.readLine();
            K = Integer.parseInt(br.readLine());

            Map<Character, ArrayList<Integer>> map = new HashMap<>();
            for (int i = 0; i < W.length(); i++) {
                if (map.containsKey(W.charAt(i))) {
                    ArrayList<Integer> temp = map.get(W.charAt(i));
                    temp.add(i);
                    map.put(W.charAt(i), temp);
                } else {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    map.put(W.charAt(i), temp);
                }
                int size = map.get(W.charAt(i)).size();
                if (size == K) {
                    min = Math.min(min, i - map.get(W.charAt(i)).get(0) + 1);
                    max = Math.max(max, i - map.get(W.charAt(i)).get(0) + 1);
                } else if (size > K) {
                    min = Math.min(min, i - map.get(W.charAt(i)).get(size - K) + 1);
                    max = Math.max(max, i - map.get(W.charAt(i)).get(size - K) + 1);
                }

            }
            if (min != Integer.MAX_VALUE && max != Integer.MIN_VALUE) {
                bw.write(min + " " + max + "\n");
            } else bw.write("-1\n");
        }
        bw.close();
    }

    static class CountIndex {
        int count;
        int index;
        public CountIndex(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }
}
