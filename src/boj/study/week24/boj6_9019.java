package boj.study.week24;

import java.io.*;
import java.util.*;

public class boj6_9019 {
    static int T;
    static int before, after;
    static boolean[] visited;
    static String[] command;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            before = Integer.parseInt(st.nextToken());
            after = Integer.parseInt(st.nextToken());
            visited = new boolean[10000];
            command = new String[10000];

            Arrays.fill(command, "");

            Queue<Integer> queue = new LinkedList<>();
            queue.add(before);
            visited[before] = true;
            while (!queue.isEmpty()) {
                int now = queue.poll();

                if (now == after) {
                    bw.write(command[now] + "\n");
                }

                int D = (now * 2) % 10000;
                int S = now == 0 ? 9999 : now - 1;
                int L = (now % 1000) * 10 + (now / 1000);
                int R = now / 10 + (now % 10) * 1000;

                if (!visited[D]) {
                    visited[D] = true;
                    queue.add(D);
                    command[D] = command[now] + "D";
                }

                if (!visited[S]) {
                    visited[S] = true;
                    queue.add(S);
                    command[S] = command[now] + "S";
                }
                if (!visited[L]) {
                    visited[L] = true;
                    queue.add(L);
                    command[L] = command[now] + "L";
                }
                if (!visited[R]) {
                    visited[R] = true;
                    queue.add(R);
                    command[R] = command[now] + "R";
                }
            }

        }
        bw.close();

    }
}
