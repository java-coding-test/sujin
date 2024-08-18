package boj.study.week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj6_13549_jy {
    static int N,K;
    static boolean[] visit=new boolean[100001];
    static int[] count=new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        Arrays.fill(count, 100000);

        if(N==K){
            System.out.println(0);
        }else{
            bfs(N);
        }

    }

    private static void bfs(int start){
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        count[start] = 0;

        while(!q.isEmpty()){
            int cur = q.poll();
            visit[cur] = true;

            if (cur == K) {
                System.out.println(count[cur]);
            }

            if (count[cur] > 3) return;

            if (cur * 2 < visit.length && !visit[cur * 2]) {
                q.add(cur * 2);
                count[cur * 2] = count[cur];
            }

            if (cur + 1 < visit.length && !visit[cur + 1]) {
                q.add(cur + 1);
                count[cur + 1] = Math.min(count[cur + 1], count[cur] + 1);
            }

            if (cur - 1 >= 0 && !visit[cur - 1]) {
                q.add(cur - 1);
                count[cur - 1] = Math.min(count[cur - 1], count[cur] + 1);
            }

        }

    }
}
