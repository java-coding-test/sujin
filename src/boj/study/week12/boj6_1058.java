package boj.study.week12;


import java.io.*;
import java.util.*;

public class boj6_1058 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        char[][] friendMatrix = new char[N][N];

        for (int i = 0; i < N; i++) {
            friendMatrix[i] = br.readLine().toCharArray();
        }

        int maxFriends = 0;

        for (int i = 0; i < N; i++) {
            Set<Integer> friends = new HashSet<>();
            for (int j = 0; j < N; j++) {
                if (i != j && friendMatrix[i][j] == 'Y') {
                    friends.add(j);
                    for (int k = 0; k < N; k++) {
                        if (k != i && friendMatrix[j][k] == 'Y') {
                            friends.add(k);
                        }
                    }
                }
            }
            maxFriends = Math.max(maxFriends, friends.size());
        }

        bw.write(maxFriends + "\n");
        bw.close();
    }
}

