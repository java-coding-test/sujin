import java.util.*;
import java.io.*;

public class boj_16953 {
    static int A, B;
    static int minCount;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        Queue<Count> q = new LinkedList<>();
        q.add(new Count(A, 1));
        while (!q.isEmpty()) {
            Count current = q.poll();
            long num = current.num;
            int count = current.count;
            if (num == B) {
                minCount = count;
                break;
            } else {
                if ((num * 10) + 1 <= B) q.add(new Count((num * 10) + 1, current.count + 1));
                if (num * 2 <= B) q.add(new Count(num * 2, current.count + 1));
            }
        }
        if (minCount != 0) bw.write(minCount + "");
        else bw.write(-1 + "");
        bw.close();
    }
    static class Count {
        long num;
        int count;
        public Count(long num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}
