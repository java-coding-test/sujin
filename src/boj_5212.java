import java.io.*;
import java.util.*;

public class boj_5212 {
    static int R, C;
    static char[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int left = 10, up = 10;
    static int right, down;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }


        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'X') {
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x >= 0 && x < R && y >= 0 && y < C) {
                            if (map[x][y] == '.') count++;
                        } else count++;
                    }
                    if (count >= 3) map[i][j] = '+';
                }
            }
        }

//        for (int i = 0; i < R; i++) {
//            for (int j = 0; j < C; j++) {
//                bw.write(map[i][j] + "");
//            }
//            bw.newLine();
//        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'X') {
                    left = Math.min(left, j);
                    up = Math.min(up, i);
                    right = Math.max(right, j);
                    down = Math.max(down, i);
                }
            }
        }
        for (int i = up; i <= down; i++) {
            for (int j = left; j <= right; j++) {
                if (map[i][j] == '+') bw.write(".");
                else bw.write(map[i][j] + "");
            }
            bw.newLine();
        }
        bw.close();
    }

}
