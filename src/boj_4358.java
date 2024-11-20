import java.util.*;
import java.io.*;

public class boj_4358 {
    static Map<String, Double> map = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int count = 0;
        while ((str = br.readLine()) != null) {
            map.put(str, map.getOrDefault(str, (double) 0) + 1);
            count++;
        }

        ArrayList<String> arr = new ArrayList<>(map.keySet());
        Collections.sort(arr);
        for (String key : arr) {
            System.out.printf("%s %.4f\n", key, (map.get(key) / count) * 100);
        }
    }
}
