import java.io.*;

public class boj_10974 {
    static int N;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];

        dfs("", 0);

    }

    public static void dfs(String str, int depth) throws IOException{
        if (depth == N) {
            System.out.println(str);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            dfs(str + i + " ", depth + 1);
            visited[i] = false;
        }
    }
}
