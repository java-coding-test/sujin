package boj.step_by_step.implementation;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    static int[][] wheels = new int[4][8];
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 4; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                wheels[i][j] = Integer.parseInt(str.substring(j, j + 1));
            }
        }

        K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] isTurn = new int[4];
        for (int i = 0; i < K; i++) {

            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());
//            turn(num, direction);
            // 왼쪽
            int left = num - 1;
            Arrays.fill(isTurn, 0);

            int currentDirection = direction;
            while(left >= 0) {
                if (wheels[left][2] != wheels[left + 1][6]) {
                    currentDirection = -currentDirection;
                    isTurn[left] = currentDirection;
                    left--;
                } else break;
            }

            // 오른쪽
            int right = num + 1;
            currentDirection = direction;
            while(right < 4) {
                if (wheels[right - 1][2] != wheels[right][6]) {
                    currentDirection = -currentDirection;
                    isTurn[right] = currentDirection;
                    right++;
                } else break;
            }

            for (int j = 0; j < 4; j++) {
                if (isTurn[j] != 0) {
                    turn(j, isTurn[j]);
                }

            }
        }

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += wheels[i][0] * (1 << i);
//            System.out.println(wheels[i][0] * (1 << i));
        }


        bw.write(sum + "");
        bw.close();
    }

    public static void turn(int num, int direction) {
        if (direction == 1) {
            int temp = wheels[num][7];
            for (int i = 0; i < 7; i++) {
                wheels[num][i + 1] = wheels[num][i];
            }
            wheels[num][0] = temp;
        } else {
            int temp = wheels[num][0];
            for (int i = 0; i < 7; i++) {
                wheels[num][i] = wheels[num][i + 1];
            }
            wheels[num][7] = temp;
        }
    }


}

class TurnAndDirection {
    boolean turn;
    int direction;

    public TurnAndDirection(boolean turn, int direction) {
        this.turn = turn;
        this.direction = direction;
    }
}